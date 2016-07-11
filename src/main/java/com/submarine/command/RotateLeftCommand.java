package com.submarine.command;

import com.submarine.domain.Submarine;

public class RotateLeftCommand implements SubmarineCommand {

    private final Submarine submarine;

    public RotateLeftCommand(Submarine submarine) {
        this.submarine = submarine;
    }

    @Override
    public void execute() {
        this.submarine.rotateLeft();
    }
}
