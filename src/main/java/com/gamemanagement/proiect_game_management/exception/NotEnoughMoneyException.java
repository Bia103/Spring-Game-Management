package com.gamemanagement.proiect_game_management.exception;

public class NotEnoughMoneyException extends RuntimeException{
    public NotEnoughMoneyException(String ExceptionMessage){
        super(ExceptionMessage);
    }
}
