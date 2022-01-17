package com.gamemanagement.proiect_game_management.mapper;

import com.gamemanagement.proiect_game_management.dto.ClubDto;
import com.gamemanagement.proiect_game_management.model.Club;
import org.springframework.stereotype.Component;

@Component
public class ClubMapper {
    public Club clubDtoToClub (ClubDto clubDto) {
        return new Club(clubDto.getClubName(), clubDto.getBonus());
    }

}
