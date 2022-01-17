package com.gamemanagement.proiect_game_management.service.service;

import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.model.Player;
import com.gamemanagement.proiect_game_management.repository.CharacterRepository;
import com.gamemanagement.proiect_game_management.repository.ClubRepository;
import com.gamemanagement.proiect_game_management.repository.PlayerDetailsRepository;
import com.gamemanagement.proiect_game_management.repository.PlayerRepository;
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
public class ClubServiceTest {

    @InjectMocks
    private ClubService clubService;

    @Mock
    private ClubRepository clubRepository;
    @Mock
    private PlayerRepository playerRepository;

    @Test
    @DisplayName("Running save Club in happy flow")
    void saveClubHappyFlow(){
        // arrange
        Club club = new Club("Region Test", "no bonus");
        when(clubRepository.save(club)).thenReturn(club);
        // act
        Club result = clubService.saveClub(club);
        // assert
        assertEquals(club.getClubName(), result.getClubName());
    }

    @Test
    @DisplayName("Running Club with players in happy flow")
    void saveClubWithPlayersHappyFlow(){
        // arrange
        Player player = new Player("test player", 1);
        List<Player> players = new ArrayList<>();
        players.add(player);
        Club club = new Club("Region Test", "no bonus", players);
        when(clubRepository.save(club)).thenReturn(club);
        List<Integer> playerIds = new ArrayList<>();
        playerIds.add(player.getPlayerId());
        // act
        Club result = clubService.saveClubWithPlayers(club, playerIds);
        // assert
        assertEquals(club.getPlayerList().size(), result.getPlayerList().size());
    }

    @Test
    @DisplayName("Running Club list in happy flow")
    void listClubHappyFlow(){
        // arrange
        Club club = new Club("Region Test", "no bonus");
        List <Club> clubs = new ArrayList<>();
        clubs.add(club);
        when(clubRepository.findAll()).thenReturn(clubs);

        // act
        List<Club> result = clubService.retrieveClubs();
        // assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(club, result.get(0));
    }

    @Test
    @DisplayName("Running Club list by name in happy flow")
    void listClubByNameHappyFlow(){
        // arrange
        Club club = new Club("Region Test", "no bonus");
        List <Club> clubs = new ArrayList<>();
        clubs.add(club);
        when(clubRepository.findClubByClubName("Region Test")).thenReturn(club);

        // act
        Club result = clubService.retrieveClubsByName("Region Test");
        // assert
        assertEquals(result.getClubName(), club.getClubName());
    }


}
