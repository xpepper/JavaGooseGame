package com.xpeppers.kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GooseGameTest {

    private GooseGame game;

    @Before
    public void setup() {
        game = new GooseGame();
    }

    @Test
    public void addsPlayerToGame() {
        String result = game.addPlayer("Pippo");

        assertEquals("Giocatori: Pippo", result);
    }

    @Test
    public void addsTwoPlayersToGame() {
        game.addPlayer("Pippo");
        String result = game.addPlayer("Pluto");

        assertEquals("Giocatori: Pippo, Pluto", result);
    }

    @Test
    public void cannotAddTwiceTheSamePlayerNameToGame() {
        game.addPlayer("Pippo");
        String result = game.addPlayer("Pippo");

        assertEquals("Pippo: giocatore già presente", result);

    }

}
