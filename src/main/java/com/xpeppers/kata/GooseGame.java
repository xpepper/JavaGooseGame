package com.xpeppers.kata;

import java.util.HashMap;
import java.util.Map;

public class GooseGame {

    private Map<Player, Integer> players = new HashMap<Player, Integer>();

    public String addPlayer(Player player) {
        if (contains(player))
            return player.getName() + ": giocatore già presente";

        players.put(player, 0);

        return "Giocatori: " + Formatter.join(players.keySet());
    }

    public String movePlayer(Player player, int firstDie, int secondDie) {
        Integer currentPosition = players.get(player);
        Integer newPosition = currentPosition + (firstDie + secondDie);
        players.put(player, newPosition);

        return player.getName() + " tira " + firstDie + ", " + secondDie + ". " + player.getName() + " muove da " + printPosition(currentPosition) + " a " + newPosition;
    }

    private String printPosition(Integer currentPosition) {
        return currentPosition == 0 ? "Partenza" : currentPosition.toString();
    }

    private boolean contains(Player player) {
        return players.keySet().contains(player);
    }

}
