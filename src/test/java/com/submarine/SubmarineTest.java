package com.submarine;

import com.submarine.model.Direction;
import com.submarine.model.NorthDirection;
import com.submarine.model.Position;
import com.submarine.model.Submarine;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class SubmarineTest {

    private Submarine submarine;

    @Before
    public void init() {
        Position position = new Position(0, 0, 0);
        Direction direction = new NorthDirection();
        submarine = new Submarine(position, direction);
    }

    @Test
    public void submarinoDeveIniciarNaPosicao_X_0() {
        assertThat(submarine.getPosition().getX(), is(0));
    }

    @Test
    public void submarinoDeveIniciarNaPosicao_Y_0() {
        assertThat(submarine.getPosition().getY(), is(0));
    }

    @Test
    public void submarinoDeveIniciarNaPosicao_Z_0() {
        assertThat(submarine.getPosition().getZ(), is(0));
    }

    @Test
    public void submarinoDeveIniciarNaDirecao_Norte() {
        assertThat(submarine.getDirection().getDescription(), is("NORTH"));
    }
}
