package ca.hccis.squash.dao;

import ca.hccis.squash.jpa.entity.SquashMatch;
import ca.hccis.squash.jpa.entity.SkillsAssessmentSquashTechnical;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SquashMatchDAO {
    private static ResultSet rs;
    private static Connection conn = null;
    private static final Logger logger = LoggerFactory.getLogger(SkillsAssessmentSquashTechnicalDAO.class);

    public SquashMatchDAO() {

        String propFileName = "application";
        ResourceBundle rb = ResourceBundle.getBundle(propFileName);
        String connectionString = rb.getString("spring.datasource.url");
        String userName = rb.getString("spring.datasource.username");
        String password = rb.getString("spring.datasource.password");

        try {
            conn = DriverManager.getConnection(connectionString, userName, password);
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    /**
     * Select all by name
     *
     * @since 20261009
     * @author BJM
     */
    public ArrayList<SquashMatch> selectAllByName(String name) {
        ArrayList<SquashMatch> squashMatches = null;
        Statement stmt = null;

        //******************************************************************
        //Use the DriverManager to get a connection to our MySql database.  Note
        //that in the dependencies, we added the Java connector to MySql which
        //will allow us to connect to a MySql database.
        //******************************************************************
        //******************************************************************
        //Create a statement object using our connection to the database.  This
        //statement object will allow us to run sql commands against the database.
        //******************************************************************
        try {

            stmt = conn.createStatement();
            String sqlStatement = "select * from SquashMatch " +
                    "where player1Name like '%"+name+"%' or player2Name like '%"+name+"%';";
            rs = stmt.executeQuery(sqlStatement);

            //******************************************************************
            //Loop through the result set using the next method.
            //******************************************************************
            squashMatches = loadList(rs);

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("There was an error closing");
            }
        }
        return squashMatches;
    }

    public ArrayList<SquashMatch> loadList(ResultSet rs) throws SQLException {
        ArrayList<SquashMatch> squashMatches = new  ArrayList();

        while (rs.next()) {

            SquashMatch squashMatch = new SquashMatch();
            squashMatch.setId(rs.getInt("id"));
            squashMatch.setMatchDate(rs.getString("matchDate"));
            squashMatch.setCreatedDateTime(rs.getString("createdDateTime"));

            squashMatch.setPlayer1Name(rs.getString("player1Name"));
            squashMatch.setPlayer2Name(rs.getString("player2Name"));

            squashMatch.setPlayer1Game1Score(rs.getByte("player1Game1Score"));
            squashMatch.setPlayer2Game1Score(rs.getByte("player2Game1Score"));

            squashMatch.setPlayer1Game2Score(rs.getByte("player1Game2Score"));
            squashMatch.setPlayer2Game2Score(rs.getByte("player2Game2Score"));

            squashMatch.setPlayer1Game3Score(rs.getByte("player1Game3Score"));
            squashMatch.setPlayer2Game3Score(rs.getByte("player2Game3Score"));

            squashMatch.setPlayer1Game4Score(rs.getByte("player1Game4Score"));
            squashMatch.setPlayer2Game4Score(rs.getByte("player2Game4Score"));

            squashMatch.setPlayer1Game5Score(rs.getByte("player1Game5Score"));
            squashMatch.setPlayer2Game5Score(rs.getByte("player2Game5Score"));

            squashMatch.setWinnerName(rs.getString("winnerName"));
            squashMatches.add(squashMatch);
        }
        return squashMatches;
    }


}
