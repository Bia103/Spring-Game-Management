package com.gamemanagement.proiect_game_management.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class PlayerDetailsDto {
    @NotNull(message = "The player must have a login date")
    private String firstLogin;
    @Column(unique = true)
    private String email;

    public String getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(String firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
