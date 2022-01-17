package com.gamemanagement.proiect_game_management.dto;

import com.gamemanagement.proiect_game_management.model.CharacterSpells;
import com.gamemanagement.proiect_game_management.model.Player;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CharacterDto {
    @NotNull(message = "Character name cannot be null!!!")
    private String characterName;

    @NotNull(message = "Character must have power")
    private int power;

    @Min(value = 1, message = "The character is unplayable with stamina lower than 1")
    private int stamina;
    @Min(value = 0, message = "We don't want to give money to players, so the price must be at least 0")
    private int price;

    @ManyToMany(mappedBy = "characterList")
    private List<Player> playerList = new ArrayList<>();

    @OneToMany(mappedBy = "characters", cascade= CascadeType.REMOVE)
    private List<CharacterSpells> characterSpells = new ArrayList<>();

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<CharacterSpells> getCharacterSpells() {
        return characterSpells;
    }

    public void setCharacterSpells(List<CharacterSpells> characterSpells) {
        this.characterSpells = characterSpells;
    }
}
