package com.xpeppers.kata;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RandomDiceRollerTest {

    @Test
    public void rollsTwoSixFacesDice() {
        DiceRoller roller = new RandomDiceRoller();

        Roll roll = roller.roll();

        assertTrue(roll.movements() >= 2);
        assertTrue(roll.movements() <= 12);
    }
}
