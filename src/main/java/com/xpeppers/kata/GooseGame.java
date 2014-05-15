package com.xpeppers.kata;

import java.util.HashMap;
import java.util.Map;

public class GooseGame {

    private Map<String, Integer> players = new HashMap<String, Integer>();

    public String addPlayer(String player) {
        if (players.keySet().contains(player))
            return player + ": giocatore già presente";

        players.put(player, 0);

        return "Giocatori: " + Formatter.join(players.keySet());
    }

    public String movePlayer(String player, int firstDie, int secondDie) {
        Integer currentPosition = players.get(player);
        Integer newPosition = currentPosition + (firstDie + secondDie);
        players.put(player, newPosition);

        return player + " tira " + firstDie + ", " + secondDie + ". " + player + " muove da " + printPosition(currentPosition)  + " a " + newPosition;
    }

    private String printPosition(Integer currentPosition) {
        return currentPosition==0 ? "Partenza" : currentPosition.toString();
    }

}
