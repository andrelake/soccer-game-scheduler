package com.andrelake.soccer_game_scheduler.api.exceptions;

import jakarta.persistence.PersistenceException;

public class PlayerNotFoundException extends PersistenceException {
    public PlayerNotFoundException() {
        super("Player not found");
    }
}
