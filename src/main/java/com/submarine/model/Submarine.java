package com.submarine.model;

public class Submarine {

    private Position position;

    public Submarine() {
        position = new Position(0, 0, 0);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
