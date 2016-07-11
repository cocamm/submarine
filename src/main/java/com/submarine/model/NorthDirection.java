package com.submarine.model;

public class NorthDirection implements Direction {

    private String description;

    public NorthDirection() {
        this.description = "NORTH";
    }

    public Direction getLeft() {
        return null;
    }

    public Direction getRight() {
        return null;
    }

    public String getDescription() {
        return description;
    }
}
