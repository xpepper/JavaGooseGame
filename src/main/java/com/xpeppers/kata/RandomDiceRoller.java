package com.xpeppers.kata;

import java.util.Date;
import java.util.Random;

public class RandomDiceRoller implements DiceRoller {

    private Random random;

    public RandomDiceRoller() {
        random = new Random(new Date().getTime());
    }

    @Override
    public Roll roll() {
        return Roll.dice(random.nextInt(6) + 1, random.nextInt(6) + 1);
    }
}
