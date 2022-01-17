package com.gamemanagement.proiect_game_management.controller;

import com.gamemanagement.proiect_game_management.dto.PlayerDto;
import com.gamemanagement.proiect_game_management.mapper.PlayerMapper;
import com.gamemanagement.proiect_game_management.model.Player;
import com.gamemanagement.proiect_game_management.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/player")
@Validated
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Player> savePlayerWithDetails(@RequestBody @Valid PlayerDto playerDto, @RequestParam int playerDetailsId) {
        Player player = playerMapper.playerDtoToPlayer(playerDto);
        return ResponseEntity.ok().body(playerService.savePlayer(player, playerDetailsId));
    }

    @PostMapping("/newPlayerWithDetails")
    public ResponseEntity<Player> savePlayerWithDetails(@RequestBody @Valid PlayerDto playerDto, @RequestParam int clubId, @RequestParam int playerDetailsId) {
        Player player = playerMapper.playerDtoToPlayer(playerDto);
        return ResponseEntity.ok().body(playerService.savePlayerWithDetails(player, clubId, playerDetailsId));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Player>> retrievePlayers(){
        return ResponseEntity.ok().body(playerService.retrievePlayers());
    }

    @DeleteMapping("/deletion/{playerId}")
    public ResponseEntity<?> deleteProject(@PathVariable int playerId){
        playerService.deletePlayerById(playerId);
        return new ResponseEntity<String>("PlayerDetailsId with id: '"+playerId+ "' was deleted", HttpStatus.OK);
    }

    @PutMapping("/purchase/{playerId}/{characterId}")
    public ResponseEntity<?> buyCharacter(@PathVariable int playerId, @PathVariable int characterId){
        playerService.buyCharacter(playerId, characterId);

        return ResponseEntity.ok().body("Successful purchase");
        // vezi cazul in care jucatorul are deja caracterul si cel in care acesta nu are suficienti bani
    }
}
