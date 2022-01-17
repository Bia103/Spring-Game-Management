package com.gamemanagement.proiect_game_management.service;

import com.gamemanagement.proiect_game_management.model.Characters;
import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.model.Player;
import com.gamemanagement.proiect_game_management.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Characters saveCharacter(Characters characters){
        return characterRepository.save(characters);
    }

    public List<Characters> retrieveCharacters() {
        return characterRepository.findAll();
    }

    public void deleteCharacter(int characterId) {
        Characters character = characterRepository.findById(characterId).orElseThrow(() -> new RuntimeException("Character Id not valid"));
        List<Player> players = character.getPlayerList();
        for(int i = 0; i < players.size(); i++) {
            players.get(i).remove(character);
        }
        characterRepository.delete(character);
    }
}
