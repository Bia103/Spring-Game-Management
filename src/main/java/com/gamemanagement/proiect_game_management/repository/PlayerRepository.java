package com.gamemanagement.proiect_game_management.repository;

import com.gamemanagement.proiect_game_management.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Modifying
    @Query(nativeQuery = true,
            value = "update player p set p.club_id = :club_id where p.player_id = :player_id")
    void joinClub(int club_id, int player_id);

    @Modifying
    @Query(nativeQuery = true,
            value = "insert into player_character (player_id, character_id) values (:player_id, :character_id)")
    void purchaseCharacter(int player_id, int character_id);

    @Modifying
    @Query(nativeQuery = true,
            value = "update player p set p.money = p.money - :amount where p.player_id = :player_id")
    void takeMoneyFromPlayer(int player_id, int amount);

    @Modifying
    @Query(nativeQuery = true,
            value = "update player p set p.money = :bonus where p.player_id = :player_id")
    void giveRewards(int player_id, int bonus);
}
