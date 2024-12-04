package com.andrelake.soccer_game_scheduler.api.domain;

import com.andrelake.soccer_game_scheduler.api.domain.dto.PlayerDTO;
import com.andrelake.soccer_game_scheduler.api.domain.enums.PositionEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private PositionEnum position;
    private Boolean hasRecurringAvailability;
    private List<DayOfWeek> days;


    public static Player toPlayer(PlayerDTO playerDTO) {
        if (playerDTO == null) {
            return null;
        }

        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setEmail(playerDTO.getEmail());
        player.setPhoneNumber(playerDTO.getPhoneNumber());
        player.setPosition(playerDTO.getPosition());
        player.setHasRecurringAvailability(playerDTO.getHasRecurringAvailability());
        player.setDays(playerDTO.getDays());

        return player;
    }

}
