package com.gamemanagement.proiect_game_management.exception;

public class PlayerAlreadyHasCharacter extends RuntimeException{
    public PlayerAlreadyHasCharacter(String ExceptionMessage){
        super(ExceptionMessage);
    }
}
