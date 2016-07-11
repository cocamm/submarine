package com.submarine.application;

import com.submarine.command.SubmarineCommand;
import com.submarine.command.translator.DefaultSubmarineCommandTranslator;
import com.submarine.command.translator.SubmarineCommandTranslator;
import com.submarine.domain.Direction;
import com.submarine.domain.DirectionsConstants;
import com.submarine.domain.Position;
import com.submarine.domain.Submarine;
import com.submarine.domain.directions.EastDirection;
import com.submarine.domain.directions.NorthDirection;
import com.submarine.domain.directions.SouthDirection;
import com.submarine.domain.directions.WestDirection;

import java.util.List;

public class SubmarineController {

    private static final int DEPTH = 0;
    private static final int X = 0;
    private static final int Y = 0;

    private Submarine submarine;
    private Position position;
    private Direction northDirection;
    private Direction westDirection;
    private Direction eastDirection;
    private Direction southDirection;
    private SubmarineCommandTranslator commandTranslator;

    public SubmarineController() {

        startNewSubmarine();

        commandTranslator = new DefaultSubmarineCommandTranslator(submarine);
    }

    private Submarine startNewSubmarine() {

        position = new Position(X, Y);

        northDirection = new NorthDirection(DirectionsConstants.NORTH);
        westDirection = new WestDirection(DirectionsConstants.WEST);
        eastDirection = new EastDirection(DirectionsConstants.EAST);
        southDirection = new SouthDirection(DirectionsConstants.SOUTH);

        northDirection.setSideDirections(westDirection, eastDirection);
        southDirection.setSideDirections(eastDirection, westDirection);
        eastDirection.setSideDirections(northDirection, southDirection);
        westDirection.setSideDirections(southDirection, northDirection);

        submarine = new Submarine(position, DEPTH, northDirection);

        return submarine;
    }

    public String navigate(String commands) {
        try {
            List<SubmarineCommand> submarineCommands = commandTranslator.translate(commands);
            for (SubmarineCommand submarineCommand : submarineCommands) {
                submarineCommand.execute();
            }

            return submarine.getPositionDescription();
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
