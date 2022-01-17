package com.gamemanagement.proiect_game_management.service;

import com.gamemanagement.proiect_game_management.model.CharacterSpells;
import com.gamemanagement.proiect_game_management.model.Characters;
import com.gamemanagement.proiect_game_management.repository.CharacterRepository;
import com.gamemanagement.proiect_game_management.repository.CharacterSpellsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterSpellsService {

    private final CharacterSpellsRepository characterSpellsRepository;
    private final CharacterRepository characterRepository;

    public CharacterSpellsService(CharacterSpellsRepository characterSpellsRepository, CharacterRepository characterRepository) {
        this.characterSpellsRepository = characterSpellsRepository;
        this.characterRepository = characterRepository;
    }
    public CharacterSpells saveCharacterSpells(CharacterSpells characterSpells, int character_id) {
        Characters character = characterRepository.findById(character_id).orElseThrow(() -> new RuntimeException("Characters details Id not valid"));
        characterSpells.setCharacters(character);
        return characterSpellsRepository.save(characterSpells);
    }

    public List<CharacterSpells> retrieveCharacterSpells() {
        return characterSpellsRepository.findAll();
    }
}
