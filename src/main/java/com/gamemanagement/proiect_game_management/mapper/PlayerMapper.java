package com.gamemanagement.proiect_game_management.mapper;

import com.gamemanagement.proiect_game_management.dto.ClubDto;
import com.gamemanagement.proiect_game_management.dto.PlayerDto;
import com.gamemanagement.proiect_game_management.model.Club;
import com.gamemanagement.proiect_game_management.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public Player playerDtoToPlayer (PlayerDto playerDto) {
        return new Player(playerDto.getDisplayName(), playerDto.getMoney());
    }
}
