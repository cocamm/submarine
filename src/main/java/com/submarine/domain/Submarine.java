package com.submarine.domain;

public class Submarine {

    private Position position;
    private Direction direction;

    public Submarine(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
