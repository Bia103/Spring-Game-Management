package com.gamemanagement.proiect_game_management.repository;

import com.gamemanagement.proiect_game_management.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Integer> {

    Club findClubByClubName(String name);
}
