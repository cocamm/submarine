package com.submarine.command;

import com.submarine.domain.Submarine;

public class UpCommand implements SubmarineCommand {

    private final Submarine submarine;

    public UpCommand(Submarine submarine) {
        this.submarine = submarine;
    }

    @Override
    public void execute() {
        this.submarine.surface();
    }
}
