package com.xpeppers.kata;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {

    private List<String> players = new ArrayList<String>();

    public String addPlayer(String name) {
        if (players.contains(name))
            return name + ": giocatore già presente";

        players.add(name);

        return "Giocatori: " + Formatter.print(players);
    }

}
