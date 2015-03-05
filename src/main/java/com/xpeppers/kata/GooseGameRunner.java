package com.xpeppers.kata;

public class GooseGameRunner {

    public static void main(String[] args) throws Exception {
        Player pippo = new Player("Pippo");
        Player pluto = new Player("Pluto");

        GooseGame game = new GooseGame();
        game.addPlayer(pippo);
        game.addPlayer(pluto);

        while (!(pippo.hasWon() || pluto.hasWon())) {
            System.out.println(game.playRound());
        }
    }

}
