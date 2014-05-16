package com.xpeppers.kata;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {

    private List<Player> players = new ArrayList<Player>();

    public String addPlayer(Player player) {
        return addPlayer(player, 0);
    }

    public String addPlayer(Player player, int initialPosition) {
        if (contains(player))
            return Response.alreadyPresent(player);

        player.setPosition(initialPosition);
        players.add(player);

        return Response.listActivePlayers(players);
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


}
