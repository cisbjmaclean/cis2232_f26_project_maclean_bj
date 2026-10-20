package ca.hccis.squash.entity;

import ca.hccis.squash.jpa.entity.SquashMatch;

public class SquashMatchScoreSummary {
    private int playerPoints;
    private String playerName;
    private String opponentPlayerName;
    private int opponentPoints;
    private SquashMatch squashMatch;

    public SquashMatchScoreSummary(SquashMatch squashMatch) {
        this.squashMatch = squashMatch;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public String getOpponentPlayerName() {
        return opponentPlayerName;
    }

    public void setOpponentPlayerName(String opponentPlayerName) {
        this.opponentPlayerName = opponentPlayerName;
    }

    public int getOpponentPoints() {
        return opponentPoints;
    }

    public void setOpponentPoints(int opponentPoints) {
        this.opponentPoints = opponentPoints;
    }

    public SquashMatch getSquashMatch() {
        return squashMatch;
    }

    public void setSquashMatch(SquashMatch squashMatch) {
        this.squashMatch = squashMatch;
    }

}
