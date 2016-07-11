package com.submarine.command;

import com.submarine.domain.Submarine;

public class DownCommand implements SubmarineCommand {

    private final Submarine submarine;

    public DownCommand(Submarine submarine) {
        this.submarine = submarine;
    }

    @Override
    public void execute() {
        this.submarine.dive();
    }
}
