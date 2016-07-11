package com.submarine;

import com.submarine.domain.Direction;
import com.submarine.domain.DirectionsConstants;
import com.submarine.domain.Position;
import com.submarine.domain.Submarine;
import com.submarine.domain.directions.EastDirection;
import com.submarine.domain.directions.NorthDirection;
import com.submarine.domain.directions.SouthDirection;
import com.submarine.domain.directions.WestDirection;
import javafx.geometry.Pos;
import org.junit.Before;

public class SubmarineTestSetup {

    protected Submarine submarine;
    protected Position position;
    protected Direction northDirection;
    protected Direction westDirection;
    protected Direction eastDirection;
    protected Direction southDirection;

    @Before
    public void setUp() {
        position = new Position(0, 0);

        northDirection = new NorthDirection(DirectionsConstants.NORTH);
        westDirection = new WestDirection(DirectionsConstants.WEST);
        eastDirection = new EastDirection(DirectionsConstants.EAST);
        southDirection = new SouthDirection(DirectionsConstants.SOUTH);

        northDirection.setSideDirections(westDirection, eastDirection);
        southDirection.setSideDirections(eastDirection, westDirection);
        eastDirection.setSideDirections(northDirection, southDirection);
        westDirection.setSideDirections(southDirection, northDirection);

        submarine = new Submarine(position, 0, northDirection);
    }
}
