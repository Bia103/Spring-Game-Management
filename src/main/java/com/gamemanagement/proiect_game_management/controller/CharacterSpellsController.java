package com.gamemanagement.proiect_game_management.controller;

import com.gamemanagement.proiect_game_management.dto.CharacterSpellsDto;
import com.gamemanagement.proiect_game_management.mapper.CharacterSpellsMapper;
import com.gamemanagement.proiect_game_management.model.CharacterSpells;
import com.gamemanagement.proiect_game_management.service.CharacterSpellsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/spells")
public class CharacterSpellsController {

    private final CharacterSpellsService characterSpellsService;
    private final CharacterSpellsMapper characterSpellsMapper;

    public CharacterSpellsController(CharacterSpellsService characterSpellsService, CharacterSpellsMapper characterSpellsMapper) {
        this.characterSpellsService = characterSpellsService;
        this.characterSpellsMapper = characterSpellsMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<CharacterSpells> saveCharacterSpells(@RequestBody @Valid CharacterSpellsDto characterSpellsDto, @RequestParam int characterId) {
        CharacterSpells characterSpells = characterSpellsMapper.characterDtoToCharacter(characterSpellsDto);
        return ResponseEntity.ok().body(characterSpellsService.saveCharacterSpells(characterSpells, characterId));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CharacterSpells>> retrieveCharacterSpells(){
        return ResponseEntity.ok().body(characterSpellsService.retrieveCharacterSpells());
    }
}
