package com.xpeppers.kata;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {

    private List<Player> players = new ArrayList<Player>();

    public String addPlayer(Player player) {
        if (contains(player))
            return player.getName() + ": giocatore già presente";

        player.placeAtStartingPosition();
        players.add(player);

        return "Giocatori: " + Formatter.join(players);
    }

    public String movePlayer(Player player, int firstDie, int secondDie) throws Exception {
        if (!contains(player))
            throw new Exception("Giocatore sconosciuto: " + player.getName());

        Integer currentPosition = player.getPosition();
        Integer newPosition = currentPosition + (firstDie + secondDie);

        player.setPosition(newPosition);

        return player.getName() + " tira " + firstDie + ", " + secondDie + ". " + player.getName() + " muove da " + printPosition(currentPosition) + " a " + newPosition;
    }

    private String printPosition(Integer currentPosition) {
        return currentPosition == 0 ? "Partenza" : currentPosition.toString();
    }

    private boolean contains(Player player) {
        return players.contains(player);
    }

}
