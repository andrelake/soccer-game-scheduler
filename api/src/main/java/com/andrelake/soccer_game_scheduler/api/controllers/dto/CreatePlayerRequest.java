package com.andrelake.soccer_game_scheduler.api.controllers.dto;

import com.andrelake.soccer_game_scheduler.api.domain.enums.PositionEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerRequest {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String phoneNumber;
    @NotNull
    private PositionEnum position;
    @NotNull
    private Boolean hasRecurringAvailability;

    private List<DayOfWeek> days;

}
