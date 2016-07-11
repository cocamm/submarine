package com.submarine.domain;

public class Submarine {

    private Position position;
    private int depth;
    private Direction direction;

    public Submarine(Position position, int depth, Direction direction) {
        this.position = position;
        this.depth = depth;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public int getDepth() {
        return depth;
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
        this.direction.moveIn(position);
    }

    public void dive() {
        this.depth--;
    }

    public void surface() {
        this.depth++;
    }

}
