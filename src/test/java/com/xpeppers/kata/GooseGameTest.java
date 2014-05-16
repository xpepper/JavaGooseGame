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
        Player pippo = new Player("Pippo");

        String result = game.addPlayer(pippo);

        assertEquals("Giocatori: Pippo", result);
    }

    @Test
    public void addsTwoPlayersToGame() {
        game.addPlayer(new Player("Pippo"));
        String result = game.addPlayer(new Player("Pluto"));

        assertEquals("Giocatori: Pippo, Pluto", result);
    }

    @Test
    public void cannotAddTwiceTheSamePlayerToGame() {
        game.addPlayer(new Player("Pippo"));
        String result = game.addPlayer(new Player("Pippo"));

        assertEquals("Pippo: giocatore già presente", result);
    }

    @Test
    public void movesPlayerFromTheStartingPosition() throws Exception {
        Player pippo = new Player("Pippo");
        Player pluto = new Player("Pluto");

        game.addPlayer(pippo);
        game.addPlayer(pluto);

        Roll roll = Roll.dice(4, 2);
        String result = game.movePlayer(pippo, roll);
        assertEquals("Pippo tira 4, 2. Pippo muove da Partenza a 6", result);

        Roll anotherRoll = Roll.dice(2, 2);
        String secondResult = game.movePlayer(pluto, anotherRoll);
        assertEquals("Pluto tira 2, 2. Pluto muove da Partenza a 4", secondResult);
    }

    @Test
    public void movesPlayerIntoANewPosition() throws Exception {
        Player pippo = new Player("Pippo");
        Player pluto = new Player("Pluto");

        game.addPlayer(pippo);
        game.addPlayer(pluto);

        Roll roll = Roll.dice(4, 2);
        String result = game.movePlayer(pippo, roll);
        assertEquals("Pippo tira 4, 2. Pippo muove da Partenza a 6", result);

        Roll anotherRoll = Roll.dice(2, 3);
        String secondResult = game.movePlayer(pippo, anotherRoll);
        assertEquals("Pippo tira 2, 3. Pippo muove da 6 a 11", secondResult);
    }

    @Test
    public void playerInPosition63Wins() throws Exception {
        Player player = new Player("Pippo");
        game.addPlayer(player, 60);

        Roll roll = Roll.dice(1, 2);
        String result = game.movePlayer(player, roll);
        assertEquals("Pippo tira 1, 2. Pippo muove da 60 a 63. Pippo vince!!", result);

    }
}
