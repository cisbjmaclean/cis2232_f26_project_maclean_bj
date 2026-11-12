package info.hccis.model.jpa;


import info.hccis.student.util.CisUtility;

public class SquashMatch {

    public SquashMatch() {
        this.setCreatedDateTime(CisUtility.getCurrentDate("yyyy-MM-dd hh:mm"));
        this.setMatchDate(CisUtility.getCurrentDate("yyyy-MM-dd"));
        this.player1Game1Score = 0;
        this.player1Game2Score = 0;
        this.player1Game3Score = 0;
        this.player1Game4Score = 0;
        this.player1Game5Score = 0;
        this.player2Game1Score = 0;
        this.player2Game2Score = 0;
        this.player2Game3Score = 0;
        this.player2Game4Score = 0;
        this.player2Game5Score = 0;

    }

    private Integer id;
    private String matchDate;
    private String createdDateTime;
    private String player1Name;
    private String player2Name;
    private Byte player1Game1Score;
    private Byte player2Game1Score;
    private Byte player1Game2Score;
    private Byte player2Game2Score;
    private Byte player1Game3Score;
    private Byte player2Game3Score;
    private Byte player1Game4Score;
    private Byte player2Game4Score;
    private Byte player1Game5Score;
    private Byte player2Game5Score;

    private String winnerName;

    public void getInformation() {

        player1Name = CisUtility.getInputString("Enter Player 1 name: ");
        player2Name = CisUtility.getInputString("Enter Player 2 name: ");

        player1Game1Score = (byte) CisUtility.getInputInt("Enter Player 1 Game 1 score: ");
        player2Game1Score = (byte) CisUtility.getInputInt("Enter Player 2 Game 1 score: ");

        player1Game2Score = (byte) CisUtility.getInputInt("Enter Player 1 Game 2 score: ");
        player2Game2Score = (byte) CisUtility.getInputInt("Enter Player 2 Game 2 score: ");

        player1Game3Score = (byte) CisUtility.getInputInt("Enter Player 1 Game 3 score: ");
        player2Game3Score = (byte) CisUtility.getInputInt("Enter Player 2 Game 3 score: ");

        player1Game4Score = (byte) CisUtility.getInputInt("Enter Player 1 Game 4 score: ");
        player2Game4Score = (byte) CisUtility.getInputInt("Enter Player 2 Game 4 score: ");

        player1Game5Score = (byte) CisUtility.getInputInt("Enter Player 1 Game 5 score: ");
        player2Game5Score = (byte) CisUtility.getInputInt("Enter Player 2 Game 5 score: ");
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public Byte getPlayer1Game1Score() {
        return player1Game1Score;
    }

    public void setPlayer1Game1Score(Byte player1Game1Score) {
        this.player1Game1Score = player1Game1Score;
    }

    public Byte getPlayer2Game1Score() {
        return player2Game1Score;
    }

    public void setPlayer2Game1Score(Byte player2Game1Score) {
        this.player2Game1Score = player2Game1Score;
    }

    public Byte getPlayer1Game2Score() {
        return player1Game2Score;
    }

    public void setPlayer1Game2Score(Byte player1Game2Score) {
        this.player1Game2Score = player1Game2Score;
    }

    public Byte getPlayer2Game2Score() {
        return player2Game2Score;
    }

    public void setPlayer2Game2Score(Byte player2Game2Score) {
        this.player2Game2Score = player2Game2Score;
    }

    public Byte getPlayer1Game3Score() {
        return player1Game3Score;
    }

    public void setPlayer1Game3Score(Byte player1Game3Score) {
        this.player1Game3Score = player1Game3Score;
    }

    public Byte getPlayer2Game3Score() {
        return player2Game3Score;
    }

    public void setPlayer2Game3Score(Byte player2Game3Score) {
        this.player2Game3Score = player2Game3Score;
    }

    public Byte getPlayer1Game4Score() {
        return player1Game4Score;
    }

    public void setPlayer1Game4Score(Byte player1Game4Score) {
        this.player1Game4Score = player1Game4Score;
    }

    public Byte getPlayer2Game4Score() {
        return player2Game4Score;
    }

    public void setPlayer2Game4Score(Byte player2Game4Score) {
        this.player2Game4Score = player2Game4Score;
    }

    public Byte getPlayer1Game5Score() {
        return player1Game5Score;
    }

    public void setPlayer1Game5Score(Byte player1Game5Score) {
        this.player1Game5Score = player1Game5Score;
    }

    public Byte getPlayer2Game5Score() {
        return player2Game5Score;
    }

    public void setPlayer2Game5Score(Byte player2Game5Score) {
        this.player2Game5Score = player2Game5Score;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "\n========== SQUASH MATCH ==========\n" +
                "Match ID:       " + id + "\n" +
                "Match Date:     " + matchDate + "\n" +
                "Created:        " + createdDateTime + "\n" +
                "---------------------------------\n" +
                "Players:\n" +
                "  Player 1:     " + player1Name + "\n" +
                "  Player 2:     " + player2Name + "\n" +
                "---------------------------------\n" +
                "Game Scores:\n" +
                "  Game 1:       " + player1Game1Score + " - " + player2Game1Score + "\n" +
                "  Game 2:       " + player1Game2Score + " - " + player2Game2Score + "\n" +
                "  Game 3:       " + player1Game3Score + " - " + player2Game3Score + "\n" +
                "  Game 4:       " + player1Game4Score + " - " + player2Game4Score + "\n" +
                "  Game 5:       " + player1Game5Score + " - " + player2Game5Score + "\n" +
                "=================================";
    }

}