package com.gamemanagement.proiect_game_management.service;

import com.gamemanagement.proiect_game_management.exception.ClubDoesntExistException;
import com.gamemanagement.proiect_game_management.model.Characters;
import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.model.Player;
import com.gamemanagement.proiect_game_management.model.PlayerDetails;
import com.gamemanagement.proiect_game_management.repository.CharacterRepository;
import com.gamemanagement.proiect_game_management.repository.ClubRepository;
import com.gamemanagement.proiect_game_management.repository.PlayerDetailsRepository;
import com.gamemanagement.proiect_game_management.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClubService {

    private final PlayerRepository playerRepository;
    private final PlayerDetailsRepository playerDetailsRepository;
    private final ClubRepository clubRepository;
    private final CharacterRepository characterRepository;

    public ClubService(PlayerRepository playerRepository, PlayerDetailsRepository playerDetailsRepository, ClubRepository clubRepository, CharacterRepository characterRepository) {
        this.playerRepository = playerRepository;
        this.playerDetailsRepository = playerDetailsRepository;
        this.clubRepository = clubRepository;
        this.characterRepository = characterRepository;
    }

    public Club saveClub(Club club){
        return clubRepository.save(club);
    }

    public Club saveClubWithPlayers(Club club, List<Integer> playerIds){
        List<Player> players = playerRepository.findAllById(playerIds);
        club.setPlayerList(players);
        
        return clubRepository.save(club);
    }

    public List<Club> retrieveClubs() {
        return clubRepository.findAll();
    }

    public Club retrieveClubsByName(String clubName) {
        return clubRepository.findClubByClubName(clubName);
    }

    public void deleteClub(int clubId) {
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new RuntimeException("Player details Id not valid"));
        List<Player> players = club.getPlayerList();
        for(int i = 0; i < players.size(); i++) {
            players.get(i).remove(club);
        }
        clubRepository.delete(club);

    }

    @Transactional
    public void joinClub(int clubId, int playerId) {
        clubRepository.findById(clubId).orElseThrow(() -> new ClubDoesntExistException("This club doesn't exist"));
        playerRepository.joinClub(clubId, playerId);
    }

    @Transactional
    public void giveRewards(int clubId) {
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new RuntimeException("Player details Id not valid"));

        List<Player> players = club.getPlayerList();

        String rewardType = club.getBonus();

        for(int i = 0; i < players.size(); i++) {
            if(rewardType.equals("double")) {
                playerRepository.giveRewards(players.get(i).getPlayerId(), players.get(i).getMoney() * 2);
            } else if(rewardType.equals("plus")) {
                playerRepository.giveRewards(players.get(i).getPlayerId(), players.get(i).getMoney() + 150);
            }
        }
    }
}
