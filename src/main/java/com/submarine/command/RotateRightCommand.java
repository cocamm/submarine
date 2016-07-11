package com.submarine.command;

import com.submarine.domain.Submarine;

public class RotateRightCommand implements SubmarineCommand {

    private final Submarine submarine;

    public RotateRightCommand(Submarine submarine) {
        this.submarine = submarine;
    }

    @Override
    public void execute() {
        this.submarine.rotateRigtht();
    }
}
