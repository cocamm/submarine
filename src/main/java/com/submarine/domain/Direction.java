package com.submarine.domain;

public abstract class Direction implements DirectionMovement {

    protected String description;
    protected Direction left;
    protected Direction right;

    public Direction(String description) {
        this.description = description;
    }

    public abstract void setSideDirections(Direction left, Direction right);

    public Direction getLeft() {
        return left;
    }

    public Direction getRight() {
        return right;
    }

    public String getDescription() {
        return description;
    }
}
