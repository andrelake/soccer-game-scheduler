package com.andrelake.soccer_game_scheduler.api.domain;

import com.andrelake.soccer_game_scheduler.api.domain.dto.MatchDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startsAt;
    private LocalDateTime createdAt;

    @ManyToMany
    private List<Player> players;

    public static Match toMatch(MatchDTO dto) {
        if (dto == null) {
            return null;
        }

        Match match = new Match();
        match.setStartsAt(dto.getStartsAt());
        match.createdAt = LocalDateTime.now();
        match.players = Collections.emptyList();
        return match;
    }

}
