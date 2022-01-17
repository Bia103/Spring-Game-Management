package com.gamemanagement.proiect_game_management.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PlayerDto {
    @NotNull(message = "Player must have a name")
    private String displayName;
    @Min(value = 0, message = "The player can't have debts")
    private int money;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
