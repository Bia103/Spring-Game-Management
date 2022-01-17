package com.gamemanagement.proiect_game_management.mapper;

import com.gamemanagement.proiect_game_management.dto.CharacterDto;
import com.gamemanagement.proiect_game_management.dto.ClubDto;
import com.gamemanagement.proiect_game_management.model.Characters;
import com.gamemanagement.proiect_game_management.model.Club;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {
    public Characters characterDtoToCharacter (CharacterDto characterDto) {
        return new Characters(characterDto.getCharacterName(), characterDto.getPower(),characterDto.getStamina(), characterDto.getPrice());
    }
}
