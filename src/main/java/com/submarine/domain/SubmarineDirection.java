package com.submarine.domain;

public class SubmarineDirection implements Direction {

    private String description;
    private Direction left;
    private Direction right;

    public SubmarineDirection(String description) {
        this.description = description;
    }

    public void setSideDirections(Direction left, Direction right) {
        this.left = left;
        this.right = right;
    }

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
