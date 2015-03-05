package com.xpeppers.kata;

import static com.xpeppers.kata.Response.alreadyPresent;
import static com.xpeppers.kata.Response.listActivePlayers;
import static com.xpeppers.kata.Response.moved;
import static com.xpeppers.kata.Response.unknownPlayer;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {

    private List<Player> players;
    private DiceRoller diceRoller;

    public GooseGame() {
        this(new RandomDiceRoller());
    }

    public GooseGame(DiceRoller roller) {
        players = new ArrayList<Player>();
        diceRoller = roller;
    }

    public String addPlayer(Player player) {
        return addPlayer(player, 0);
    }

    public String addPlayer(Player player, int startingPosition) {
        if (contains(player)) {
            return alreadyPresent(player);
        }

        player.setPosition(startingPosition);
        players.add(player);

        return listActivePlayers(players);
    }

    public String movePlayer(Player player) throws Exception {
        Roll roll = diceRoller.roll();
        return movePlayer(player, roll);
    }

    public String movePlayer(Player player, Roll roll) throws Exception {
        if (!contains(player)) {
            throw new Exception(unknownPlayer(player));
        }

        player.move(roll);

        return moved(player, roll);
    }

    public String playRound() throws Exception {
        StringBuffer console = new StringBuffer();
        for (Player each : players) {
            String roundResult = movePlayer(each);
            console.append(roundResult).append("\n");
        }
        return console.toString();
    }

    private boolean contains(Player player) {
        return players.contains(player);
    }
}
