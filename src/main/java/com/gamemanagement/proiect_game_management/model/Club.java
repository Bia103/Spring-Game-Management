package com.gamemanagement.proiect_game_management.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clubId;
    @NotEmpty(message = "The club must have a name")
    private String clubName;
    @NotNull(message = "Why would you join a club without a bonus?")
    private String bonus;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Player> playerList = new ArrayList<>();

    public Club() {
    }

    public Club(String clubName, String bonus) {
        this.clubName = clubName;
        this.bonus = bonus;
    }

    public Club(int clubId, String name, String bonus) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.bonus = bonus;
    }

    public Club(String clubName, String bonus, List<Player> playerList) {
        this.clubName = clubName;
        this.bonus = bonus;
        this.playerList = playerList;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
