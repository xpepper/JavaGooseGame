package com.xpeppers.kata;

import static com.xpeppers.kata.Response.alreadyPresent;
import static com.xpeppers.kata.Response.listActivePlayers;
import static com.xpeppers.kata.Response.moved;
import static com.xpeppers.kata.Response.unknownPlayer;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {

    private static final int STARTING_POSITION = 0;

    private List<Player> players;
    private DiceRoller diceRoller;

    public static GooseGame withPlayers(String... playerNames) {
        GooseGame game = new GooseGame();
        for (String name : playerNames) {
            game.addPlayer(new Player(name));
        }
        return game;
    }

    public GooseGame() {
        this(new RandomDiceRoller());
    }

    public GooseGame(DiceRoller roller) {
        players = new ArrayList<Player>();
        diceRoller = roller;
    }

    public String addPlayer(Player player) {
        return addPlayer(player, STARTING_POSITION);
    }

    String addPlayer(Player player, int initialPosition) {
        if (contains(player)) {
            return alreadyPresent(player);
        }

        player.setPosition(initialPosition);
        players.add(player);

        return listActivePlayers(players);
    }

    public String movePlayer(Player player) throws Exception {
        Roll roll = diceRoller.roll();
        return movePlayer(player, roll);
    }

    public String movePlayer(Player player, Roll roll) throws Exception {
        if (!contains(player)) {
            throw new Exception(unknownPlayer(player));
        }

        player.move(roll);

        return moved(player, roll);
    }

    public List<String> playRound() throws Exception {
        List<String> roundLog = new ArrayList<>();
        for (Player player : players) {
            String roundResult = movePlayer(player);
            roundLog.add(roundResult);
            if (player.hasWon()) {
                break;
            }
        }
        return roundLog;
    }

    public List<String> run() throws Exception {
        List<String> gameLog = new ArrayList<>();
        while (!hasWinner()) {
            List<String> roundLog = playRound();
            gameLog.addAll(roundLog);
        }
        return gameLog;
    }

    private boolean hasWinner() {
        for (Player player : players) {
            if (player.hasWon()) {
                return true;
            }
        }
        return false;
    }

    private boolean contains(Player player) {
        return players.contains(player);
    }

}
