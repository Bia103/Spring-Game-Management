package com.gamemanagement.proiect_game_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamemanagement.proiect_game_management.model.Characters;

public interface CharacterRepository extends JpaRepository<Characters, Integer> {
}
