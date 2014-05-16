package com.xpeppers.kata;

import java.util.Collection;
import java.util.List;

public class Response {

    static String alreadyPresent(Player player) {
        return player.getName() + ": giocatore già presente";
    }

    static String listActivePlayers(List<Player> players) {
        return "Giocatori: " + join(players);
    }

    static String unknownPlayer(Player player) {
        return "Giocatore sconosciuto: " + player.getName();
    }

    static String moved(Player player, Roll roll) {
        String message = rollMessage(player, roll) + movingMessage(player);
        if (player.hasWon())
            message += winMessage(player);

        return message;
    }

    private static String movingMessage(Player player) {
        return player.getName() + " muove da " + printPosition(player) + " a " + player.getPosition();
    }

    private static String winMessage(Player player) {
        return ". " + player.getName() + " vince!!";
    }

    private static String rollMessage(Player player, Roll roll) {
        return player.getName() + " tira " + roll + ". ";
    }

    private static String join(Collection<Player> players) {
        StringBuffer buffer = new StringBuffer();
        for (Player s : players) {
            if (buffer.length() > 0)
                buffer.append(", ");

            buffer.append(s.getName());
        }
        return buffer.toString();
    }

    private static String printPosition(Player player) {
        Integer previousPosition = player.getPreviousPosition();
        return previousPosition == 0 ? "Partenza" : previousPosition.toString();
    }

}
