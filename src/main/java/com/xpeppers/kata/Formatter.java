package com.xpeppers.kata;

import java.util.Collection;

public class Formatter {

    public static String join(Collection<Player> players) {
        StringBuffer buffer = new StringBuffer();
        for (Player s : players) {
            if (buffer.length() > 0)
                buffer.append(", ");

            buffer.append(s.getName());
        }
        return buffer.toString();
    }

}
