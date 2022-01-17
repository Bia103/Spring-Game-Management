package com.gamemanagement.proiect_game_management.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClubDto {

    @NotEmpty(message = "The club must have a name")
    private String clubName;
    @NotNull(message = "Why would you join a club without a bonus?")
    private String bonus;

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
}
