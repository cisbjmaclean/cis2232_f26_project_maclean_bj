package ca.hccis.squash.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "squashmatch")
public class SquashMatch {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 10)
    @NotNull
    @Column(name = "matchDate", nullable = false, length = 10)
    private String matchDate;

    @Size(max = 100)
    @NotNull
    @Column(name = "createdDateTime", nullable = false, length = 100)
    private String createdDateTime;

    @Size(max = 100)
    @NotNull
    @Column(name = "player1Name", nullable = false, length = 100)
    private String player1Name;

    @Size(max = 100)
    @NotNull
    @Column(name = "player2Name", nullable = false, length = 100)
    private String player2Name;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player1Game1Score", nullable = false)
    private Byte player1Game1Score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player2Game1Score", nullable = false)
    private Byte player2Game1Score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player1Game2Score", nullable = false)
    private Byte player1Game2Score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player2Game2Score", nullable = false)
    private Byte player2Game2Score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player1Game3Score", nullable = false)
    private Byte player1Game3Score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player2Game3Score", nullable = false)
    private Byte player2Game3Score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player1Game4Score", nullable = false)
    private Byte player1Game4Score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player2Game4Score", nullable = false)
    private Byte player2Game4Score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player1Game5Score", nullable = false)
    private Byte player1Game5Score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "player2Game5Score", nullable = false)
    private Byte player2Game5Score;

    @Size(max = 100)
    @NotNull
    @Column(name = "winnerName", nullable = false, length = 100)
    private String winnerName;

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

}