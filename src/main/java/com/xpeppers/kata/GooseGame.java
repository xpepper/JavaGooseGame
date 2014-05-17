package com.xpeppers.kata;

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
        if (contains(player))
            return Response.alreadyPresent(player);

        player.setPosition(startingPosition);
        players.add(player);

        return Response.listActivePlayers(players);
    }

    public String movePlayer(Player player) throws Exception {
        Roll roll = diceRoller.roll();
        return movePlayer(player, roll);
    }

    public String movePlayer(Player player, Roll roll) throws Exception {
        if (!contains(player))
            throw new Exception(Response.unknownPlayer(player));

        player.move(roll);

        return Response.moved(player, roll);
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

    public static void main(String[] args) throws Exception {
        Player pippo = new Player("Pippo");
        Player pluto = new Player("Pluto");

        GooseGame g = new GooseGame();
        g.addPlayer(pippo);
        g.addPlayer(pluto);

        while (!(pippo.hasWon() || pluto.hasWon())) {
            System.out.println(g.playRound());
        }
    }

}
