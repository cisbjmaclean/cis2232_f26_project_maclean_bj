package ca.hccis.squash.bo;

import ca.hccis.squash.entity.ReportInput;
import ca.hccis.squash.entity.SquashMatchScoreSummary;
import ca.hccis.squash.jpa.entity.SquashMatch;

import java.util.ArrayList;

/**
 * Class to hold business logic needed for the report.
 *
 * @author BJM
 * @since 20261020
 */
public class ReportBO {
    public static void processPlayerScoreReport(ReportInput reportInput) {

        //Get all of the matches
        SquashMatchBO squashMatchBO = new SquashMatchBO();
        ArrayList<SquashMatch> theList = squashMatchBO.processSelectAllByName(reportInput.getName());

        //Process through the matches and get score summaries.
        ArrayList<SquashMatchScoreSummary> squashMatchScoreSummaries = new ArrayList<>();
        for (SquashMatch current : theList) {

            //filter out if match is before the start date
            if (reportInput.getStartDate() != null && !reportInput.getStartDate().isEmpty()) {
                if (current.getMatchDate().compareTo(reportInput.getStartDate()) < 0) {
                    System.out.println("Skipping match " + current.getMatchDate() + " because it is before the start date");
                    continue;
                }
            }
            //filter out if match is after the date
            if (reportInput.getEndDate() != null && !reportInput.getEndDate().isEmpty()) {
                if (current.getMatchDate().compareTo(reportInput.getEndDate()) > 0) {
                    System.out.println("Skipping match " + current.getMatchDate() + " because it is after the end date");
                    continue;
                }
            }

            SquashMatchScoreSummary squashMatchScoreSummary = new SquashMatchScoreSummary(current);

            int totalPoints = 0;
            int totalOpponentPoints = 0;

            int totalPointsPlayer1 = current.getPlayer1Game1Score()
                    + current.getPlayer1Game2Score()
                    + current.getPlayer1Game3Score()
                    + current.getPlayer1Game4Score()
                    + current.getPlayer1Game5Score();
            int totalPointsPlayer2 = current.getPlayer2Game1Score()
                    + current.getPlayer2Game2Score()
                    + current.getPlayer2Game3Score()
                    + current.getPlayer2Game4Score()
                    + current.getPlayer2Game5Score();

            if (current.getPlayer1Name().equalsIgnoreCase(reportInput.getName())) {
                totalPoints = totalPointsPlayer1;
                totalOpponentPoints = totalPointsPlayer2;
                squashMatchScoreSummary.setOpponentPlayerName(current.getPlayer2Name());
            } else if (current.getPlayer2Name().equalsIgnoreCase(reportInput.getName())) {
                totalPoints = totalPointsPlayer2;
                totalOpponentPoints = totalPointsPlayer1;
                squashMatchScoreSummary.setOpponentPlayerName(current.getPlayer1Name());
            }
            squashMatchScoreSummary.setPlayerPoints(totalPoints);
            squashMatchScoreSummary.setPlayerName(reportInput.getName());
            squashMatchScoreSummary.setOpponentPoints(totalOpponentPoints);
            squashMatchScoreSummaries.add(squashMatchScoreSummary);
        }
        reportInput.setSquashMatchScoreSummaries(squashMatchScoreSummaries);
    }
}
