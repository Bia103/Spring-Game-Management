package com.gamemanagement.proiect_game_management.controller;

import com.gamemanagement.proiect_game_management.dto.ClubDto;
import com.gamemanagement.proiect_game_management.mapper.ClubMapper;
import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {

    private final ClubService clubService;
    private final ClubMapper clubMapper;

    public ClubController(ClubService clubService, ClubMapper clubMapper) {
        this.clubService = clubService;
        this.clubMapper = clubMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Club> saveClub(@RequestBody @Valid ClubDto clubDto) {
        Club club = clubMapper.clubDtoToClub(clubDto);
        return ResponseEntity.ok().body(clubService.saveClub(club));
    }

    @PostMapping("/newClubWithPlayers")
    public ResponseEntity<Club> saveClubWithPlayers(@RequestBody @Valid ClubDto clubDto, @RequestParam List<Integer> playerIds) {
        Club club = clubMapper.clubDtoToClub(clubDto);
        return ResponseEntity.ok().body(clubService.saveClubWithPlayers(club, playerIds));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Club>> retrieveClubs(){
        return ResponseEntity.ok().body(clubService.retrieveClubs());
    }

    @GetMapping("/clubByName")
    public ResponseEntity<Club> retrieveByName(@RequestParam String clubName){
        return ResponseEntity.ok().body(clubService.retrieveClubsByName(clubName));
    }

    @DeleteMapping("/deletion/{clubId}")
    public ResponseEntity<?> deleteClubId(@PathVariable int clubId){
        clubService.deleteClub(clubId);
        return new ResponseEntity<String>("Club with id: '"+clubId+ "' was deleted", HttpStatus.OK);
    }

    @PutMapping("/newMemeber/{clubId}/{playerId}")
    public void joinClub(@PathVariable int clubId, @PathVariable int playerId){
        clubService.joinClub(clubId, playerId);
    }

    @PutMapping("/rewards/{clubId}")
    public void giveRewards(@PathVariable int clubId){
        clubService.giveRewards(clubId);
    }
}
