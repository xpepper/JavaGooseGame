package com.xpeppers.kata;

import java.util.List;

public class Formatter {

    public static String print(List<String> strings) {
        StringBuffer buffer = new StringBuffer();
        for (String p : strings) {
            if (buffer.length() > 0)
                buffer.append(", ");
    
            buffer.append(p);
        }
        return buffer.toString();
    }

}
