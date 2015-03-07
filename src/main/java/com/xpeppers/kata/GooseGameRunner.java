package com.xpeppers.kata;

import java.util.List;

public class GooseGameRunner {

    public static void main(String[] args) throws Exception {
        GooseGame game = GooseGame.withPlayers("Pippo", "Pluto");

        List<String> gameLog = game.run();
        System.out.println(gameLog);
    }

}
