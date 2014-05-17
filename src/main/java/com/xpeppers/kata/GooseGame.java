package com.xpeppers.kata;

import java.util.ArrayList;
import java.util.Iterator;
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
        if (contains(player))
            return Response.alreadyPresent(player);

        player.setPosition(startingPosition);
        players.add(player);

        return Response.listActivePlayers(players);
    }

    public String movePlayer(Player player) throws Exception {
        return movePlayer(player, diceRoller.roll());
    }

    public String movePlayer(Player player, Roll roll) throws Exception {
        if (!contains(player))
            throw new Exception(Response.unknownPlayer(player));

        player.doMove(roll);

        return Response.moved(player, roll);
    }

    private boolean contains(Player player) {
        return players.contains(player);
    }

    public String playRound() throws Exception {
        StringBuffer buffer = new StringBuffer();
        for (Player p : players) {
            buffer.append(movePlayer(p));
            buffer.append("\n");
        }
        return buffer.toString();

    }

}
