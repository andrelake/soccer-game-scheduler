package com.andrelake.soccer_game_scheduler.api.repositories;

import com.andrelake.soccer_game_scheduler.api.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> { }