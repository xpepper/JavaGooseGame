package com.xpeppers.kata;

public class Roll {

    private int firstDie;
    private int secondDie;

    private Roll(int firstDie, int secondDie) {
        this.firstDie = firstDie;
        this.secondDie = secondDie;
    }

    public static Roll dice(int firstDie, int secondDie) {
        return new Roll(firstDie, secondDie);
    }

    public Integer movements() {
        return firstDie + secondDie;
    }

    @Override
    public String toString() {
        return firstDie + ", " + secondDie;
    }

}
