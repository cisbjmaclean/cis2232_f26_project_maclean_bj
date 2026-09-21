package ca.hccis.squash.entity;

import ca.hccis.squash.bo.MatchBO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatchTest {

    @Test
    void testDetermineWinnerPlayer1_11_0s() {

        Match match = new Match();

        match.setPlayer1Game1Score(11);
        match.setPlayer2Game1Score(0);
        match.setPlayer1Game2Score(11);
        match.setPlayer2Game2Score(0);
        match.setPlayer1Game3Score(11);
        match.setPlayer2Game3Score(0);

        int actual = MatchBO.determineWinner(match);

        Assertions.assertEquals(1, actual);
    }

    @Test
    void testDetermineWinnerPlayer1_13_11s() {

        Match match = new Match();

        match.setPlayer1Game1Score(13);
        match.setPlayer2Game1Score(11);
        match.setPlayer1Game2Score(13);
        match.setPlayer2Game2Score(11);
        match.setPlayer1Game3Score(13);
        match.setPlayer2Game3Score(11);

        int actual = MatchBO.determineWinner(match);

        Assertions.assertEquals(1, actual);
    }

    @Test
    void testDetermineWinnerPlayer2_13_11s() {

        Match match = new Match();

        match.setPlayer1Game1Score(11);
        match.setPlayer2Game1Score(13);
        match.setPlayer1Game2Score(11);
        match.setPlayer2Game2Score(13);
        match.setPlayer1Game3Score(11);
        match.setPlayer2Game3Score(13);

        int actual = MatchBO.determineWinner(match);

        Assertions.assertEquals(2, actual);
    }



}