package com.gamemanagement.proiect_game_management.service;

import com.gamemanagement.proiect_game_management.exception.NotEnoughMoneyException;
import com.gamemanagement.proiect_game_management.exception.PlayerAlreadyHasCharacter;
import com.gamemanagement.proiect_game_management.model.Characters;
import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.model.Player;
import com.gamemanagement.proiect_game_management.model.PlayerDetails;
import com.gamemanagement.proiect_game_management.repository.CharacterRepository;
import com.gamemanagement.proiect_game_management.repository.ClubRepository;
import com.gamemanagement.proiect_game_management.repository.PlayerDetailsRepository;
import com.gamemanagement.proiect_game_management.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerDetailsRepository playerDetailsRepository;
    private final ClubRepository clubRepository;
    private final CharacterRepository characterRepository;

    public PlayerService(PlayerRepository playerRepository, PlayerDetailsRepository playerDetailsRepository, ClubRepository clubRepository, CharacterRepository characterRepository) {
        this.playerRepository = playerRepository;
        this.playerDetailsRepository = playerDetailsRepository;
        this.clubRepository = clubRepository;
        this.characterRepository = characterRepository;
    }

    public Player savePlayerWithDetails(Player player, int clubId, int playerDetailsId) {
        PlayerDetails playerDetails = playerDetailsRepository.findById(playerDetailsId).orElseThrow(() -> new RuntimeException("Player details Id not valid"));
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new RuntimeException("Club Id not valid"));

        player.setPlayerDetails(playerDetails);
        player.setClub(club);

        return playerRepository.save(player);
    }

    public Player savePlayer(Player player, int playerDetailsId) {
        PlayerDetails playerDetails = playerDetailsRepository.findById(playerDetailsId).orElseThrow(() -> new RuntimeException("Player details Id not valid"));

        player.setPlayerDetails(playerDetails);
        return playerRepository.save(player);
    }

    public List<Player> retrievePlayers() {
        return playerRepository.findAll();
    }

    public void deletePlayerById(int playerId){

        Player player = playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player details Id not valid"));
        PlayerDetails playerDetails = player.getPlayerDetails();

        playerRepository.delete(player);

        playerDetailsRepository.delete(playerDetails);
    }

    @Transactional
    public void buyCharacter(int playerId, int characterId) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player Id not valid"));
        int playerMoney = player.getMoney();

        Characters character = characterRepository.findById(characterId).orElseThrow(() -> new RuntimeException("Character Id not valid"));
        int characterPrice = character.getPrice();

        List<Characters> characters = player.getCharacterList();

        for(int i = 0; i < characters.size(); i++) {
            if(characters.get(i).getCharacterId() == characterId) {
                throw new PlayerAlreadyHasCharacter("This player already has this character");
            }

        }

        if(playerMoney - characterPrice >= 0){
            playerRepository.purchaseCharacter(playerId, characterId);
            playerRepository.takeMoneyFromPlayer(playerId, characterPrice);
        } else {
            throw new NotEnoughMoneyException("You don't have enough money to buy this character!");
        }
    }
}
