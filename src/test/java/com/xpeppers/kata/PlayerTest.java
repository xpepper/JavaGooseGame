package com.xpeppers.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testEquality() {
        Player piero = new Player("Piero");
        Player paolo = new Player("Paolo");
        Player anotherPiero = new Player("Piero");

        assertEquals(piero, piero);
        assertEquals(anotherPiero, piero);

        assertNotEquals(piero, paolo);
    }

    @Test
    public void testHashCode() throws Exception {
        Player piero = new Player("Piero");
        Player paolo = new Player("Paolo");
        Player anotherPiero = new Player("Piero");

        assertEquals(anotherPiero.hashCode(), piero.hashCode());

        assertNotEquals(piero.hashCode(), paolo.hashCode());
    }



}
