package com.gamemanagement.proiect_game_management.mapper;

import com.gamemanagement.proiect_game_management.dto.ClubDto;
import com.gamemanagement.proiect_game_management.dto.PlayerDetailsDto;
import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.model.PlayerDetails;
import org.springframework.stereotype.Component;

@Component
public class PlayerDetailsMapper {
    public PlayerDetails playerDetailsDtoToPlayerDetails (PlayerDetailsDto playerDetailsDto) {
        return new PlayerDetails(playerDetailsDto.getFirstLogin(), playerDetailsDto.getEmail());
    }
}
