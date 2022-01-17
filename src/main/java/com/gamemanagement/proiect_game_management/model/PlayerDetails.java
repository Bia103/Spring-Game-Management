package com.gamemanagement.proiect_game_management.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class PlayerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerDetailsId;
    @Column(name = "creation_date")
    @NotNull(message = "The player must have a login date")
    private String firstLogin;
    @Column(unique = true)
    private String email;

    public PlayerDetails() {
    }

    public PlayerDetails(String firstLogin, String email) {
        this.firstLogin = firstLogin;
        this.email = email;
    }

    public PlayerDetails(int playerDetailsId, String firstLogin, String email) {
        this.playerDetailsId = playerDetailsId;
        this.firstLogin = firstLogin;
        this.email = email;
    }

    public int getPlayerDetailsId() {
        return playerDetailsId;
    }

    public void setPlayerDetailsId(int playerDetailsId) {
        this.playerDetailsId = playerDetailsId;
    }

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
