package com.gamemanagement.proiect_game_management;

import com.gamemanagement.proiect_game_management.model.*;
import com.gamemanagement.proiect_game_management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ProiectGameManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProiectGameManagementApplication.class, args);
    }

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerDetailsRepository playerDetailsRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterSpellsRepository characterSpellsRepository;

    @Override
    public void run(String... args) throws Exception {
        PlayerDetails playerDetails1 = new PlayerDetails("10.10.2921", "bia@gmail.com");
        PlayerDetails playerDetails2 = new PlayerDetails("1.10.2951", "ele@gmail.com");
        PlayerDetails playerDetails3 = new PlayerDetails("12.16.2921", "cosmy@gmail.com");

        playerDetailsRepository.save(playerDetails1);
        playerDetailsRepository.save(playerDetails2);
        playerDetailsRepository.save(playerDetails3);

        Club club1 = new Club("Monstadt", "double");
        Club club2 = new Club("Inazuma", "plus");

        clubRepository.save(club1);
        clubRepository.save(club2);
//
        Player player1 = new Player("Bianca", 100);
        Player player2 = new Player("Elena", 53);
        Player player3 = new Player("Cosmin", 0);

        Characters character1 = new Characters("Zhongli", 7, 9, 50);
        Characters character2 = new Characters("Eula", 19, 3, 23);
        Characters character3 = new Characters("Tartaglia", 10, 7, 5);

        CharacterSpells characterSpells1 = new CharacterSpells("rock", -4);
        CharacterSpells characterSpells2 = new CharacterSpells("rock Bigg", -8);
        CharacterSpells characterSpells3 = new CharacterSpells("freeze", -3);
        CharacterSpells characterSpells4 = new CharacterSpells("Tarta-cu-fructe", -3);

        characterSpells1.setCharacters(character1);
        characterSpells2.setCharacters(character1);
        characterSpells3.setCharacters(character2);
        characterSpells4.setCharacters(character3);

        characterRepository.save(character1);
        characterRepository.save(character2);
        characterRepository.save(character3);

        characterSpellsRepository.save(characterSpells1);
        characterSpellsRepository.save(characterSpells2);
        characterSpellsRepository.save(characterSpells3);
        characterSpellsRepository.save(characterSpells4);

        player1.setPlayerDetails(playerDetails1);
        player2.setPlayerDetails(playerDetails2);
        player3.setPlayerDetails(playerDetails3);

        player1.setClub(club1);
        player2.setClub(club2);
        player3.setClub(club1);

        player1.setCharacterList(Arrays.asList(character1, character2, character3));
        player2.setCharacterList(Arrays.asList(character2));
        player3.setCharacterList(Arrays.asList(character1, character3));

        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);

    }
}
