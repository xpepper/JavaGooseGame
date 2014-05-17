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
        String rollMessage = rollMessage(player, roll);
        String movingMessage = movingMessage(player);

        StringBuffer message = new StringBuffer();
        message.append(rollMessage).append(movingMessage);

        if (player.hasWon())
            message.append(winMessage(player));

        if (player.hasBounced())
            message.append(bounceMessage(player));

        return message.toString();
    }

    private static String bounceMessage(Player player) {
        return ". " + player.getName() + " Rimbalza! " + player.getName() + " torna a " + player.getPosition();
    }

    private static String movingMessage(Player player) {
        return player.getName() + " muove da " + positionOf(player) + " a " + player.candidatePosition();
    }

    private static String winMessage(Player player) {
        return ". " + player.getName() + " vince!!";
    }

    private static String rollMessage(Player player, Roll roll) {
        return player.getName() + " tira " + roll + ". ";
    }

    private static String join(Collection<Player> players) {
        StringBuffer buffer = new StringBuffer();
        for (Player each : players) {
            if (buffer.length() > 0)
                buffer.append(", ");

            buffer.append(each.getName());
        }
        return buffer.toString();
    }

    public static String positionOf(Player player) {
        return player.isInStartingPosition() ? "Partenza" : player.getPreviousPosition().toString();
    }

}
