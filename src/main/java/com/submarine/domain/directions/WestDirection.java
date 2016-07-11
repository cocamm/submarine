package com.submarine.domain.directions;

import com.submarine.domain.Direction;
import com.submarine.domain.Position;

public class WestDirection extends Direction {

    public WestDirection(String description) {
        super(description);
    }

    public void setSideDirections(Direction left, Direction right) {
        this.left = left;
        this.right = right;
    }

    public void moveIn(Position position) {
        int currentX = position.getX();
        position.setX(--currentX);
    }

}
