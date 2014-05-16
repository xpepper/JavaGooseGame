package com.xpeppers.kata;

public class Player {

    private String name;
    private int position;
    private int previousPosition;

    public Player(String name) {
        this.name = name;
        this.previousPosition = this.position = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass())
            return false;
        Player another = (Player) obj;

        return another.name.equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    boolean hasWon() {
        return getPosition() == 63;
    }
    void doMove(Roll roll) {
        Integer currentPosition = getPosition();
        Integer newPosition = currentPosition + roll.movements();

        previousPosition = currentPosition;
        position = newPosition;
    }

    Integer getPosition() {
        return position;
    }

    void setPosition(int position) {
        this.position = position;
    }

    Integer getPreviousPosition() {
        return previousPosition;
    }

}
