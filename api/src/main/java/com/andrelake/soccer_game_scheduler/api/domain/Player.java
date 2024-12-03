package com.andrelake.soccer_game_scheduler.api.domain;

import com.andrelake.soccer_game_scheduler.api.domain.enums.PositionEnum;
import lombok.Data;

import java.time.DayOfWeek;
import java.util.List;

@Data
public class Player {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private PositionEnum position;
    private Boolean hasRecurringAvailability;
    private List<DayOfWeek> days;
}
