package com.gamemanagement.proiect_game_management.service.service;

import com.gamemanagement.proiect_game_management.model.Characters;
import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.repository.CharacterRepository;
import com.gamemanagement.proiect_game_management.repository.ClubRepository;
import com.gamemanagement.proiect_game_management.service.CharacterService;
import com.gamemanagement.proiect_game_management.service.ClubService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterTest {
    @InjectMocks
    private CharacterService characterService;

    @Mock
    private CharacterRepository characterRepository;

    @Test
    @DisplayName("Running save Character in happy flow")
    void saveCharacterHappyFlow(){
        // arrange
        Characters character = new Characters("abc", 12 ,3);
        when(characterRepository.save(character)).thenReturn(character);
        // act
        Characters result = characterService.saveCharacter(character);
        // assert
        assertEquals(character.getCharacterName(), result.getCharacterName());
    }

    @Test
    @DisplayName("Running Character list in happy flow")
    void listClubHappyFlow(){
        // arrange
        Characters character = new Characters("abc", 12 ,3);
        List<Characters> characters = new ArrayList<>();
        characters.add(character);
        when(characterRepository.findAll()).thenReturn(characters);

        // act
        List<Characters> result = characterService.retrieveCharacters();
        // assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(character, result.get(0));
    }

    @Test
    @DisplayName("Running delete Character in happy flow")
    void deleteCharacterHappyFlow(){
        // arrange
        Characters character = new Characters("abc", 12 ,3);
        List<Characters> characters = new ArrayList<>();
        characters.add(character);
        when(characterRepository.findAll()).thenReturn(characters);

        // act
        List<Characters> result = characterService.retrieveCharacters();
        // assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(character, result.get(0));
    }
}
