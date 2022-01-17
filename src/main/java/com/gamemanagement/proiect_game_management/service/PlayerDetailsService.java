package com.gamemanagement.proiect_game_management.service;

import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.model.Player;
import com.gamemanagement.proiect_game_management.model.PlayerDetails;
import com.gamemanagement.proiect_game_management.repository.PlayerDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerDetailsService {

    private final PlayerDetailsRepository playerDetailsRepository;

    public PlayerDetailsService(PlayerDetailsRepository playerDetailsRepository) {
        this.playerDetailsRepository = playerDetailsRepository;
    }

    public PlayerDetails savePlayerDetails(PlayerDetails playerDetails){
        return playerDetailsRepository.save(playerDetails);
    }

    public List<PlayerDetails> retrievePlayerDetails() {
        return playerDetailsRepository.findAll();
    }

    public void deletePlayerDetails(PlayerDetails playerDetails) {
        playerDetailsRepository.delete(playerDetails);
    }
}
