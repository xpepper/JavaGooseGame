package com.xpeppers.kata;

public class Player {

    private static final int WINNING_FIELD = 63;

    private String name;
    private int position;
    private int previousPosition;
    private boolean bounced;

    public Player(String name) {
        this.name = name;
        this.previousPosition = this.position = 0;
        this.bounced = false;
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
        return getPosition() == Player.WINNING_FIELD;
    }

    boolean hasBounced() {
        return bounced;
    }

    void doMove(Roll roll) {
        bounced = false;
        Integer currentPosition = position;
        Integer newPosition = currentPosition + roll.movements();

        if (newPosition > WINNING_FIELD) {
            newPosition = bounceFrom(newPosition);
        }

        previousPosition = currentPosition;
        position = newPosition;
    }

    Integer candidatePosition() {
        return hasBounced() ? WINNING_FIELD : getPosition();
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

    private Integer bounceFrom(int overflowPosition) {
        bounced = true;
        return WINNING_FIELD - (overflowPosition % WINNING_FIELD);
    }

    boolean isInStartingPosition() {
        return getPreviousPosition() == 0;
    }

}
