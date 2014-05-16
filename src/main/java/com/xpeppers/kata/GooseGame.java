package com.xpeppers.kata;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {

    private List<Player> players = new ArrayList<Player>();

    public String addPlayer(Player player) {
        if (contains(player))
            return Response.alreadyPresent(player);

        players.add(player);

        return Response.listActivePlayers(players);
    }

    public String movePlayer(Player player, int firstDie, int secondDie) throws Exception {
        if (!contains(player))
            throw new Exception(Response.unknownPlayer(player));

        player.doMove(firstDie, secondDie);

        return Response.moved(player, firstDie, secondDie);
    }

    private boolean contains(Player player) {
        return players.contains(player);
    }

}
