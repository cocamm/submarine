package com.submarine.domain.directions;

import com.submarine.domain.Direction;
import com.submarine.domain.DirectionsConstants;
import com.submarine.domain.Position;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DirectionTest {

    private Direction northDirection;
    private Direction westDirection;
    private Direction eastDirection;
    private Direction southDirection;
    private Position position;

    @Before
    public void setUp() {
        northDirection = new NorthDirection(DirectionsConstants.NORTH);
        westDirection = new WestDirection(DirectionsConstants.WEST);
        eastDirection = new EastDirection(DirectionsConstants.EAST);
        southDirection = new SouthDirection(DirectionsConstants.SOUTH);

        northDirection.setSideDirections(westDirection, eastDirection);
        southDirection.setSideDirections(eastDirection, westDirection);
        eastDirection.setSideDirections(northDirection, southDirection);
        westDirection.setSideDirections(southDirection, northDirection);
        position = new Position(0, 0);
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

    @Test
    public void deveSomarUmAoEixoXAoMoverParaOLeste() {
        eastDirection.moveIn(position);

        assertThat(position.getX(), is(1));
    }

    @Test
    public void deveSubtrairUmDoEixoXAoMoverParaOeste() {
        westDirection.moveIn(position);

        assertThat(position.getX(), is(-1));
    }

    @Test
    public void deveSomarUmAoEixoYAoMoverParaONorte() {
        northDirection.moveIn(position);

        assertThat(position.getY(), is(1));
    }

    @Test
    public void deveSubtrairUmAoEixoYAoMoverParaOSul() {
        southDirection.moveIn(position);

        assertThat(position.getY(), is(-1));
    }

}
