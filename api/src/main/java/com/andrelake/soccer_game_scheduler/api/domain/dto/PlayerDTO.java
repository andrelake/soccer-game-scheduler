package com.andrelake.soccer_game_scheduler.api.domain.dto;

import com.andrelake.soccer_game_scheduler.api.controllers.dto.CreatePlayerRequest;
import com.andrelake.soccer_game_scheduler.api.domain.enums.PositionEnum;
import lombok.*;

import java.time.DayOfWeek;
import java.util.List;

@Data
@Builder
public class PlayerDTO {

    private String name;
    private String email;
    private String phoneNumber;
    private PositionEnum position;
    private Boolean hasRecurringAvailability;
    private List<DayOfWeek> days;


    public static PlayerDTO toPlayerDTO(CreatePlayerRequest request) {
        return PlayerDTO.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .position(request.getPosition())
                .hasRecurringAvailability(request.getHasRecurringAvailability())
                .days(request.getDays())
                .build();
    }
}
