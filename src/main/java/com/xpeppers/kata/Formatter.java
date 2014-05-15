package com.xpeppers.kata;

import java.util.Collection;

public class Formatter {

    public static String join(Collection<String> strings) {
        StringBuffer buffer = new StringBuffer();
        for (String s : strings) {
            if (buffer.length() > 0)
                buffer.append(", ");

            buffer.append(s);
        }
        return buffer.toString();
    }

}
