package com.submarine.command.translator;

import com.submarine.command.SubmarineCommand;
import com.submarine.command.SubmarineCommandFactory;
import com.submarine.domain.Submarine;

import java.util.ArrayList;
import java.util.List;

public class DefaultSubmarineCommandTranslator implements SubmarineCommandTranslator {

    private final Submarine submarine;
    private List<SubmarineCommand> submarineCommands;

    public DefaultSubmarineCommandTranslator(Submarine submarine) {
        this.submarine = submarine;
        this.submarineCommands = new ArrayList<SubmarineCommand>();
    }

    @Override
    public List<SubmarineCommand> translate(String commands) {

        String[] cmdsArray = commands.split("");
        for (String command : cmdsArray) {

            if(validCommand(command)) {
                SubmarineCommand submarineCommand = new SubmarineCommandFactory(submarine).create(command);
                this.submarineCommands.add(submarineCommand);
            }
        }

        return this.submarineCommands;
    }

    private boolean validCommand(String command) {
        return true;
    }
}
