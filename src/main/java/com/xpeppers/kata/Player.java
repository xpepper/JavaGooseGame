package com.xpeppers.kata;

public class Player {

    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
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

    void setPosition(int position) {
        this.position = position;
    }

    Integer getPosition() {
        return position;
    }

    void placeAtStartingPosition() {
        setPosition(0);
    }
}
