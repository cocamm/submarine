package com.submarine.domain;

public interface Direction {

    void setSideDirections(Direction left, Direction right);

    Direction getLeft();

    Direction getRight();

    String getDescription();
}
