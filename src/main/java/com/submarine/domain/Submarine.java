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


    public void rotateRigtht() {
        direction = direction.getRight();
    }

    public void rotateLeft() {
        direction = direction.getLeft();
    }

    public void move() {
        this.position.setX(1);
    }
}
