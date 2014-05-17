package com.xpeppers.kata;

import java.util.Date;
import java.util.Random;


public class RandomDiceRoller implements DiceRoller {

    @Override
    public Roll roll() {
        Random random = new Random(new Date().getTime());
        return Roll.dice(random.nextInt(5)+1, random.nextInt(5)+1);
    }

}
