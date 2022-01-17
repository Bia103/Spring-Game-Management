package com.gamemanagement.proiect_game_management.controller;

import com.gamemanagement.proiect_game_management.model.Player;
import com.gamemanagement.proiect_game_management.model.PlayerDetails;
import com.gamemanagement.proiect_game_management.service.PlayerDetailsService;
import com.gamemanagement.proiect_game_management.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/playerDetails")
public class PlayerDetailsController {

    private final PlayerDetailsService playerDetailsService;

    public PlayerDetailsController(PlayerDetailsService playerDetailsService) {
        this.playerDetailsService = playerDetailsService;
    }

    @PostMapping("/new")
    public ResponseEntity<PlayerDetails> savePlayerDetails(@RequestBody @Valid PlayerDetails playerDetails) {
        return ResponseEntity.ok().body(playerDetailsService.savePlayerDetails(playerDetails));
    }

    @GetMapping("/list")
    public ResponseEntity<List<PlayerDetails>> retrievePlayersDetails(){
        return ResponseEntity.ok().body(playerDetailsService.retrievePlayerDetails());
    }


}
