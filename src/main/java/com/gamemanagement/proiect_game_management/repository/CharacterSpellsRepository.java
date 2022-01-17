package com.gamemanagement.proiect_game_management.repository;

import com.gamemanagement.proiect_game_management.model.CharacterSpells;
import com.gamemanagement.proiect_game_management.model.Characters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterSpellsRepository extends JpaRepository<CharacterSpells, Integer> {
}
