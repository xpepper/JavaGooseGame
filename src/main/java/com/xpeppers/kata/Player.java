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

    Integer getPosition() {
        return position;
    }

    Integer getPreviousPosition() {
        return previousPosition;
    }

    void doMove(int firstDie, int secondDie) {
        Integer currentPosition = getPosition();
        Integer newPosition = currentPosition + (firstDie + secondDie);

        previousPosition = currentPosition;
        position = newPosition;
    }
}
