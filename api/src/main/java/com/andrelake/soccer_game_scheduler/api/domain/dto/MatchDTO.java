package com.andrelake.soccer_game_scheduler.api.domain.dto;

import com.andrelake.soccer_game_scheduler.api.controllers.dto.CreateMatchRequest;
import com.andrelake.soccer_game_scheduler.api.domain.Match;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class MatchDTO {

    private Long id;
    private LocalDateTime startsAt;
    private LocalDateTime createdAt;
    private List<PlayerDTO> players;

    public static MatchDTO toMatchDTO(CreateMatchRequest request) {
        return MatchDTO.builder()
                .startsAt(request.getStartsAt())
                .build();
    }

    public static MatchDTO toMatchDTO(Match match) {
        return MatchDTO.builder()
                .id(match.getId())
                .createdAt(match.getCreatedAt())
                .players(match.getPlayers().stream().map(PlayerDTO::toPlayerDTO).toList())
                .startsAt(match.getStartsAt())
                .build();
    }

}
