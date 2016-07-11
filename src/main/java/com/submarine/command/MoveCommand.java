package com.submarine.command;

import com.submarine.domain.Submarine;

public class MoveCommand implements SubmarineCommand {

    private final Submarine submarine;

    public MoveCommand(Submarine submarine) {
        this.submarine = submarine;
    }

    @Override
    public void execute() {
        this.submarine.move();
    }
}
