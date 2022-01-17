package com.gamemanagement.proiect_game_management.exceptionhandling;

import com.gamemanagement.proiect_game_management.exception.ClubDoesntExistException;
import com.gamemanagement.proiect_game_management.exception.NotEnoughMoneyException;
import com.gamemanagement.proiect_game_management.exception.PlayerAlreadyHasCharacter;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotEnoughMoneyException.class, PlayerAlreadyHasCharacter.class, ClubDoesntExistException.class})
    public ResponseEntity<?> handleException(RuntimeException exception) {
        Map<String, String> responseParameters = new HashMap<>();
        responseParameters.put("Reason: ", exception.getMessage());
        responseParameters.put("DateTime: ", LocalDateTime.now().toString());

        return ResponseEntity.badRequest().body(responseParameters);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleApiValidation(MethodArgumentNotValidException exception) {
        Map<String, Object> responseParameters = new HashMap<>();

        List<String> errors = exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        responseParameters.put("Reason: ", errors);
        responseParameters.put("DateTime: ", LocalDateTime.now().toString());

        return ResponseEntity.badRequest().body(responseParameters);
    }
}
