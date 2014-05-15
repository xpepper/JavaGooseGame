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
    public void cannotAddTwiceTheSamePlayerToGame() {
        game.addPlayer("Pippo");
        String result = game.addPlayer("Pippo");

        assertEquals("Pippo: giocatore già presente", result);
    }

    @Test
    public void movesPlayerFromTheStartingPosition() throws Exception {
        game.addPlayer("Pippo");
        game.addPlayer("Pluto");

        String result = game.movePlayer("Pippo", 4, 2);
        assertEquals("Pippo tira 4, 2. Pippo muove da Partenza a 6", result);

        String secondResult = game.movePlayer("Pluto", 2, 2);
        assertEquals("Pluto tira 2, 2. Pluto muove da Partenza a 4", secondResult);
    }

    @Test
    public void movesPlayerIntoANewPosition() throws Exception {
        game.addPlayer("Pippo");

        String result = game.movePlayer("Pippo", 4, 2);
        assertEquals("Pippo tira 4, 2. Pippo muove da Partenza a 6", result);

        String secondResult = game.movePlayer("Pippo", 2, 3);
        assertEquals("Pippo tira 2, 3. Pippo muove da 6 a 11", secondResult);

    }

}
