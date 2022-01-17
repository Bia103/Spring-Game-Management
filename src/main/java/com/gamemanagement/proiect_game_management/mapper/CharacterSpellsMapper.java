package com.gamemanagement.proiect_game_management.mapper;

import com.gamemanagement.proiect_game_management.dto.CharacterDto;
import com.gamemanagement.proiect_game_management.dto.CharacterSpellsDto;
import com.gamemanagement.proiect_game_management.model.CharacterSpells;
import com.gamemanagement.proiect_game_management.model.Characters;
import org.springframework.stereotype.Component;

@Component
public class CharacterSpellsMapper {
    public CharacterSpells characterDtoToCharacter (CharacterSpellsDto characterSpellsDto) {
        return new CharacterSpells(characterSpellsDto.getSpellName(), characterSpellsDto.getStaminaConsumption());
    }
}
