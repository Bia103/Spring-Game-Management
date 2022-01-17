package com.gamemanagement.proiect_game_management.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class CharacterSpellsDto {
    @NotNull(message = "Spell name must not be null")
    private String spellName;

    @Max(value = 0, message = "Stamina must be consumed!")
    private int staminaConsumption;

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
}
