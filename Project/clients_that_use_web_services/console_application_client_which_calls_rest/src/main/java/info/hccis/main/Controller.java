package info.hccis.main;

import com.google.gson.Gson;
import info.hccis.model.jpa.SquashMatch;
import info.hccis.student.util.CisUtility;
import info.hccis.student.util.UtilityRest;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.Scanner;

public class Controller {

    final public static String MENU = "\nMain Menu \nA) Add\n"
            + "U) Update\n"
            + "V) View\n"
            + "D) Delete\n"
            + "X) eXit";
    final static Scanner input = new Scanner(System.in);
    private static final String URL_STRING = "http://localhost:8081/api/SquashMatchService/v1/squashMatches";

    public static void main(String[] args) {
        boolean endProgram = false;
        do {
            System.out.println(MENU);
            String choice = input.nextLine();
            SquashMatch squashMatch;
            String url;
            switch (choice.toUpperCase()) {
                case "A":
                    squashMatch = create();
                    url = URL_STRING;
                    System.out.println("Url=" + url);
                    SquashMatch squashMatchTemp = (SquashMatch) UtilityRest.addUsingRest(url, squashMatch);
                    if (squashMatchTemp != null) {
                        System.out.println("Added new entity:" + squashMatchTemp.toString());
                    }
                    break;
                case "U":
                    squashMatch = update();
                    url = URL_STRING;
                    System.out.println("Url="+url);
                    squashMatch = UtilityRest.updateUsingRest(url+"/"+squashMatch.getId(), squashMatch);
                    squashMatch.display();
                    break;
                case "D":
                    System.out.println("Enter id to delete");
                    Scanner input = new Scanner(System.in);
                    int id = input.nextInt();
                    input.nextLine();  //burn
                    UtilityRest.deleteUsingRest(URL_STRING, id);
                    break;
                case "V":
                    view(false);
                    break;
                case "X":
                    endProgram = true;
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        } while (!endProgram);
    }

    /**
     * Create an object by passing asking user for input.
     *
     * @return object
     * @author BJM
     * @since 20261112
     */
    public static SquashMatch create() {
        SquashMatch squashMatch = new SquashMatch();
        squashMatch.getInformation();
        return squashMatch;
    }

    /**
     * Update an object by passing asking user for input.
     *
     * @return object
     * @author BJM
     * @since 20261116
     */
    public static SquashMatch update() {
        System.out.println("Here are the matches");
        HashMap<Integer, SquashMatch> map = view(true);
        int idToUpdate = CisUtility.getInputInt("Which id?");

        SquashMatch squashMatch = map.get(idToUpdate);
        squashMatch.getInformation();
        return squashMatch;
    }

    public static HashMap<Integer,SquashMatch> view(boolean condensed) {
        String jsonReturned = UtilityRest.getJsonFromRest(URL_STRING);
        //**************************************************************
        //Based on the json string passed back, loop through each json
        //object which is a json string in an array of json strings.
        //*************************************************************
        HashMap<Integer, SquashMatch> matchesMap = new HashMap<>();
        if (jsonReturned != null && !jsonReturned.isEmpty()) {
            JSONArray jsonArray = new JSONArray(jsonReturned);
            //**************************************************************
            //For each json object in the array, show the first and last names
            //**************************************************************
            System.out.println("Here are the rows");
            Gson gson = new Gson();
            for (int currentIndex = 0; currentIndex < jsonArray.length(); currentIndex++) {
                //System.out.println(jsonArray.getJSONObject(currentIndex).toString());
                SquashMatch current = gson.fromJson(jsonArray.getJSONObject(currentIndex).toString(), SquashMatch.class);
                matchesMap .put(current.getId(),current);
                if (condensed) {
                    System.out.println(current.getId() + " " + current.getPlayer1Name() + " " + current.getPlayer2Name() + " on " + current.getCreatedDateTime());
                } else {
                    System.out.println(current.toString());
                }
            }
        }
        return matchesMap;
    }
}
