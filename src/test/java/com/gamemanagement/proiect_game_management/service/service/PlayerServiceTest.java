package com.gamemanagement.proiect_game_management.service.service;

import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.model.Player;
import com.gamemanagement.proiect_game_management.model.PlayerDetails;
import com.gamemanagement.proiect_game_management.repository.PlayerDetailsRepository;
import com.gamemanagement.proiect_game_management.repository.PlayerRepository;
import com.gamemanagement.proiect_game_management.service.PlayerDetailsService;
import com.gamemanagement.proiect_game_management.service.PlayerService;
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
public class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private PlayerDetailsRepository playerDetailsRepository;

//    @Test
//    @DisplayName("Running save Player Details in happy flow")
//    void savePlayerDetailsHappyFlow(){
//        // arrange
//        Player player = new Player("gigel", 5);
//        PlayerDetails playerDetails = new PlayerDetails("ceva", "rt");
//        player.setPlayerDetails(playerDetails);
//        playerDetailsRepository.save(playerDetails);
//        when(playerRepository.save(player)).thenReturn(player);
//        // act
//        Player result = playerService.savePlayer(player, playerDetails.getPlayerDetailsId());
//        // assert
//        assertEquals(player.getDisplayName(), result.getDisplayName());
//    }

    @Test
    @DisplayName("Running Club list in happy flow")
    void listPlayerHappyFlow(){
        // arrange
        Player player = new Player("gigel", 5);
        List<Player> players = new ArrayList<>();
        players.add(player);
        when(playerRepository.findAll()).thenReturn(players);

        // act
        List<Player> result = playerService.retrievePlayers();
        // assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(player, result.get(0));
    }
}
