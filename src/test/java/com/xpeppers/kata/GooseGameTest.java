package com.xpeppers.kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        Player pippo = addPlayerToGame("Pippo");
        Player pluto = addPlayerToGame("Pluto");

        Roll roll = Roll.dice(4, 3);
        String result = game.movePlayer(pippo, roll);
        assertEquals("Pippo tira 4, 3. Pippo muove da Partenza a 7", result);

        Roll anotherRoll = Roll.dice(2, 2);
        String secondResult = game.movePlayer(pluto, anotherRoll);
        assertEquals("Pluto tira 2, 2. Pluto muove da Partenza a 4", secondResult);
    }

    @Test
    public void movesPlayerIntoANewPosition() throws Exception {
        Player pippo = addPlayerToGame("Pippo");

        Roll roll = Roll.dice(4, 3);
        String result = game.movePlayer(pippo, roll);
        assertEquals("Pippo tira 4, 3. Pippo muove da Partenza a 7", result);

        Roll anotherRoll = Roll.dice(2, 3);
        String secondResult = game.movePlayer(pippo, anotherRoll);
        assertEquals("Pippo tira 2, 3. Pippo muove da 7 a 12", secondResult);
    }

    @Test
    public void playerInPosition63Wins() throws Exception {
        Player player = new Player("Pippo");
        game.addPlayer(player, 60);

        Roll roll = Roll.dice(1, 2);
        String result = game.movePlayer(player, roll);
        assertEquals("Pippo tira 1, 2. Pippo muove da 60 a 63. Pippo vince!!", result);
    }

    @Test
    public void playerBounceWhenGoBeyond63() throws Exception {
        Player player = new Player("Pippo");
        game.addPlayer(player, 60);

        Roll roll = Roll.dice(3, 2);
        String result = game.movePlayer(player, roll);
        assertEquals("Pippo tira 3, 2. Pippo muove da 60 a 63. Pippo Rimbalza! Pippo torna a 61", result);
    }

    @Test
    public void bouncingIsForgottenOnceIsOccurred() throws Exception {
        Player player = new Player("Pippo");
        game.addPlayer(player, 60);

        game.movePlayer(player, Roll.dice(3, 3));
        String result = game.movePlayer(player, Roll.dice(1, 1));
        assertEquals("Pippo tira 1, 1. Pippo muove da 60 a 62", result);
    }

    @Test
    public void gameRollTheDice() throws Exception {
        Player player = new Player("Pippo");
        game = new GooseGame(stubRollerWithDice(2,2));
        game.addPlayer(player, 4);

        assertEquals("Pippo tira 2, 2. Pippo muove da 4 a 8", game.movePlayer(player));
    }

    @Test
    public void gamePlaysARound() throws Exception {
        game = new GooseGame(stubRollerWithDice(2,3));

        addPlayerToGame("Pippo");
        addPlayerToGame("Pluto");

        String result = game.playRound();

        assertEquals("Pippo tira 2, 3. Pippo muove da Partenza a 5\nPluto tira 2, 3. Pluto muove da Partenza a 5\n", result);
    }

    @Test
    public void field6IsTheBridge() throws Exception {
        Player player = new Player("Pippo");
        game = new GooseGame(stubRollerWithDice(1, 1));
        game.addPlayer(player, 4);

        assertEquals("Pippo tira 1, 1. Pippo muove da 4 a Il Ponte. Pippo salta al 12", game.movePlayer(player));
    }

    private DiceRoller stubRollerWithDice(final int firstDie, final int secondDie) {
        return new DiceRoller() {
            @Override
            public Roll roll() {
                return Roll.dice(firstDie, secondDie);
            }
        };
    }

    private Player addPlayerToGame(String name) {
        Player pippo = new Player(name);
        game.addPlayer(pippo);
        return pippo;
    }

}
