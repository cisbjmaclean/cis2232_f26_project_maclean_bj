package ca.hccis.squash.bo;

import ca.hccis.squash.entity.Match;

public class MatchBO {

    /**
     * Determine the winner based on the scores of the games.
     *
     * @return 1 if player 1 wins, 2 if player 2 wins, 0 if there is no winnder based on the scores
     * @author BJM
     * @since 20260921
     */
    public static int determineWinner(Match match) {

        if(determineWinnerOfGame(match.getPlayer1Game1Score(), match.getPlayer2Game1Score()) == 1
                && determineWinnerOfGame(match.getPlayer1Game2Score(), match.getPlayer2Game2Score()) == 1
                && determineWinnerOfGame(match.getPlayer1Game3Score(), match.getPlayer2Game3Score()) == 1){
            return 1;
        } else if(determineWinnerOfGame(match.getPlayer2Game1Score(), match.getPlayer1Game1Score()) == 1
                && determineWinnerOfGame(match.getPlayer2Game2Score(), match.getPlayer1Game2Score()) == 1
                && determineWinnerOfGame(match.getPlayer2Game3Score(), match.getPlayer1Game3Score()) == 1){
            return 2;
        } else {
            return 0;
        }
    }

    public static int determineWinnerOfGame(int player1Score, int player2Score){
        //If player 1 has reached 11 and is ahead by at least 2, they are the winner
        if (player1Score >= 11 && player1Score - player2Score >= 2) {
            return 1;
        } else {
            return 999;
        }

    }


}
