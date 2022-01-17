package com.gamemanagement.proiect_game_management.controller;

import com.gamemanagement.proiect_game_management.dto.CharacterDto;
import com.gamemanagement.proiect_game_management.mapper.CharacterMapper;
import com.gamemanagement.proiect_game_management.model.Characters;
import com.gamemanagement.proiect_game_management.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Characters> saveCharacter(@RequestBody @Valid CharacterDto charactersDto) {
        Characters character = characterMapper.characterDtoToCharacter(charactersDto);
        return ResponseEntity.ok().body(characterService.saveCharacter(character));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Characters>> retrieveCharacters(){
        return ResponseEntity.ok().body(characterService.retrieveCharacters());
    }

    @DeleteMapping("/deletion/{characterId}")
    public ResponseEntity<?> deleteClubId(@PathVariable int characterId){
        characterService.deleteCharacter(characterId);
        return new ResponseEntity<String>("Club with id: '"+characterId+ "' was deleted", HttpStatus.OK);
    }

}
