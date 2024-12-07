package com.andrelake.soccer_game_scheduler.api.repositories;

import com.andrelake.soccer_game_scheduler.api.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}