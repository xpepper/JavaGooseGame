package com.xpeppers.kata;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {
    private static Map<Integer, String> gameFields = new HashMap<Integer, String>();
    static {
        for (Integer i = 0; i <= Player.WINNING_FIELD; i++) {
            gameFields.put(i, i.toString());
        }
        gameFields.put(0, "Partenza");
    }

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

        if (player.hasJumped())
            message.append(jumpMessage(player));

        return message.toString();
    }

    private static String jumpMessage(Player player) {
        return ". " + player.getName() + " salta al 12";
    }

    private static String bounceMessage(Player player) {
        return ". " + player.getName() + " Rimbalza! " + player.getName() + " torna a " + player.getPosition();
    }

    private static String movingMessage(Player player) {
        return player.getName() + " muove da " + startingPosition(player) + " a " + endingPosition(player);
    }

    public static String startingPosition(Player player) {
        return gameFields.get(player.getPreviousPosition());
    }

    private static String endingPosition(Player player) {
        gameFields.put(6, "Il Ponte");

        return gameFields.get(player.candidatePosition());
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

}
