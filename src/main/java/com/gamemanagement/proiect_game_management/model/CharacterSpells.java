package com.gamemanagement.proiect_game_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
public class CharacterSpells {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterSpellId;

    @NotNull(message = "Spell name must not be null")
    private String spellName;

    @Max(value = 0, message = "Stamina must be consumed!")
    private int staminaConsumption;

    @ManyToOne
    @JoinColumn(name = "character_id")
    @JsonIgnore
    private Characters characters;

    public CharacterSpells() {
    }

    public CharacterSpells(String spellName, int staminaConsumption, Characters characters) {
        this.spellName = spellName;
        this.staminaConsumption = staminaConsumption;
        this.characters = characters;
    }

    public CharacterSpells(int characterSpellId, String spellName, int staminaConsumption) {
        this.characterSpellId = characterSpellId;
        this.spellName = spellName;
        this.staminaConsumption = staminaConsumption;
    }

    public CharacterSpells(String spellName, int staminaConsumption) {
        this.spellName = spellName;
        this.staminaConsumption = staminaConsumption;
    }

    public int getCharacterSpellId() {
        return characterSpellId;
    }

    public void setCharacterSpellId(int characterSpellId) {
        this.characterSpellId = characterSpellId;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getStaminaConsumption() {
        return staminaConsumption;
    }

    public void setStaminaConsumption(int staminaConsumption) {
        this.staminaConsumption = staminaConsumption;
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }
}
