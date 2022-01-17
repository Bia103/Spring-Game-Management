package com.gamemanagement.proiect_game_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    @NotNull(message = "Player must have a name")
    private String displayName;
    @Min(value = 0, message = "The player can't have debts")
    private int money;

    @OneToOne
    @JoinColumn(name = "player_details_id")
    private PlayerDetails playerDetails;

    @ManyToOne
    @JoinColumn(name = "club_id")
    @JsonIgnore
    private Club club;

    @ManyToMany
    @JoinTable(name = "player_character", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "character_id"))
    @JsonIgnore
    private List<Characters> characterList = new ArrayList<>();

    public Player() {
    }

    public Player(String displayName, int money) {
        this.displayName = displayName;
        this.money = money;
    }

    public Player(int playerId, String displayName) {
        this.playerId = playerId;
        this.displayName = displayName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Characters> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Characters> characterList) {
        this.characterList = characterList;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public PlayerDetails getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(PlayerDetails playerDetails) {
        this.playerDetails = playerDetails;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public void remove(Characters character) {
        this.characterList.remove(character);
    }

    public void remove(Club club) {
        this.characterList.remove(club);
    }
}
