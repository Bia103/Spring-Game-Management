package com.gamemanagement.proiect_game_management.exception;

public class ClubDoesntExistException extends RuntimeException{
    public ClubDoesntExistException(String ExceptionMessage){
        super(ExceptionMessage);
    }
}
