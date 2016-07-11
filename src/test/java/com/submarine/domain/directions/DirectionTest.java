package com.submarine.domain.directions;

import com.submarine.SubmarineTestSetup;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DirectionTest extends SubmarineTestSetup {

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
