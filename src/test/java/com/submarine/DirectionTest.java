package com.submarine;

import com.submarine.domain.Direction;
import com.submarine.domain.DirectionsConstants;
import com.submarine.domain.SubmarineDirection;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DirectionTest {

    private Direction northDirection;
    private Direction westDirection;
    private Direction eastDirection;
    private Direction southDirection;

    @Before
    public void init() {
        northDirection = new SubmarineDirection(DirectionsConstants.NORTH);
        westDirection = new SubmarineDirection(DirectionsConstants.WEST);
        eastDirection = new SubmarineDirection(DirectionsConstants.EAST);
        southDirection = new SubmarineDirection(DirectionsConstants.SOUTH);

        northDirection.setSideDirections(westDirection, eastDirection);
        southDirection.setSideDirections(eastDirection, westDirection);
        eastDirection.setSideDirections(northDirection, southDirection);
        westDirection.setSideDirections(southDirection, northDirection);
    }


    @Test
    public void criarUmaDirecaoNorte() {
        assertNotNull(northDirection);
        assertThat(northDirection.getDescription(), is("NORTH"));
    }

    @Test
    public void direcaoNorteDeveTerLeftIgualOeste() {
        assertThat(northDirection.getLeft(), is(westDirection));
    }

    @Test
    public void direcaoNorteDeveTerLeftIgualLest() {
        assertThat(northDirection.getRight(), is(eastDirection));
    }

    @Test
    public void direcaoLesteDeveTerComoLeftDirecaoNorte() {
        assertThat(eastDirection.getLeft(), is(northDirection));
    }
}
