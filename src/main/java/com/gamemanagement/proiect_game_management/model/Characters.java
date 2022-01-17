package com.gamemanagement.proiect_game_management.model;

import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterId;

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

    @OneToMany(mappedBy = "characters", cascade=CascadeType.REMOVE)
    private List<CharacterSpells> characterSpells = new ArrayList<>();

    public Characters() {
    }

    public Characters(String name, int power, int stamina) {
        this.characterName = name;
        this.power = power;
        this.stamina = stamina;
    }

    public Characters(int characterId, String name, int power, int stamina, int price) {
        this.characterId = characterId;
        this.characterName = name;
        this.power = power;
        this.stamina = stamina;
        this.price = price;
    }

    public Characters(String name, int power, int stamina, int price) {
        this.characterName = name;
        this.power = power;
        this.stamina = stamina;
        this.price = price;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String name) {
        this.characterName = name;
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

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<CharacterSpells> getCharacterSpells() {
        return characterSpells;
    }

    public void setCharacterSpells(List<CharacterSpells> characterSpells) {
        this.characterSpells = characterSpells;
    }
}
