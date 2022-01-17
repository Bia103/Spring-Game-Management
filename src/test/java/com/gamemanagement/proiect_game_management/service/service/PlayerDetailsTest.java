package com.gamemanagement.proiect_game_management.service.service;

import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.model.PlayerDetails;
import com.gamemanagement.proiect_game_management.repository.PlayerDetailsRepository;
import com.gamemanagement.proiect_game_management.service.PlayerDetailsService;
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
public class PlayerDetailsTest {

    @InjectMocks
    private PlayerDetailsService playerDetailsService;

    @Mock
    private PlayerDetailsRepository playerDetailsRepository;

    @Test
    @DisplayName("Running save Player Details in happy flow")
    void savePlayerDetailsHappyFlow(){
        // arrange
        PlayerDetails playerDetails = new PlayerDetails("ceva", "rt");
        when(playerDetailsRepository.save(playerDetails)).thenReturn(playerDetails);
        // act
        PlayerDetails result = playerDetailsService.savePlayerDetails(playerDetails);
        // assert
        assertEquals(playerDetails.getEmail(), result.getEmail());
    }

    @Test
    @DisplayName("Running Player Details list in happy flow")
    void listClubHappyFlow(){
        // arrange
        PlayerDetails playerDetail = new PlayerDetails("candva", "no");
        List<PlayerDetails> playerDetails = new ArrayList<>();
        playerDetails.add(playerDetail);
        when(playerDetailsRepository.findAll()).thenReturn(playerDetails);

        // act
        List<PlayerDetails> result = playerDetailsService.retrievePlayerDetails();
        // assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(playerDetail, result.get(0));
    }


}
