package com.submarine;

import com.submarine.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class SubmarineTest {

    private Submarine submarine;

    private Direction northDirection;
    private Direction westDirection;
    private Direction eastDirection;
    private Direction southDirection;

    @Before
    public void init() {
        Position position = new Position(0, 0);

        northDirection = new SubmarineDirection(DirectionsConstants.NORTH);
        westDirection = new SubmarineDirection(DirectionsConstants.WEST);
        eastDirection = new SubmarineDirection(DirectionsConstants.EAST);
        southDirection = new SubmarineDirection(DirectionsConstants.SOUTH);

        northDirection.setSideDirections(westDirection, eastDirection);
        southDirection.setSideDirections(eastDirection, westDirection);
        eastDirection.setSideDirections(northDirection, southDirection);
        westDirection.setSideDirections(southDirection, northDirection);


        submarine = new Submarine(position, 0, northDirection);
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
    public void submarinoDeveIniciarComProfundidade_0() {
        assertThat(submarine.getDepth(), is(0));
    }

    @Test
    public void submarinoDeveIniciarNaDirecao_Norte() {
        assertThat(submarine.getDirection().getDescription(), is("NORTH"));
    }

    @Test
    public void deveAlterarADirecaoDoSubmarinoParaLeste() {
        submarine.rotateRigtht();

        assertThat(submarine.getDirection().getDescription(), is("EAST"));
    }

    @Test
    public void deveAlterarADirecaoDoSubmarinoParaOeste() {
        submarine.rotateLeft();

        assertThat(submarine.getDirection().getDescription(), is("WEST"));
    }

    @Test
    public void deveMoverOSubmarino1UnidadeParaONorte() {
        submarine.move();

        assertThat(submarine.getDirection().getDescription(), is("NORTH"));
        assertThat(submarine.getPosition().getX(), is(1));

    }

    @Test
    public void deveAlterarAProfundidadeDoSubmarinoParaMenos3() {
        submarine.dive();
        submarine.dive();
        submarine.dive();

        assertThat(submarine.getDepth(), is(-3));
    }

    @Test
    public void deveAlterarAProfundidadeDoSubmarinoPara2() {
        submarine.surface();
        submarine.surface();

        assertThat(submarine.getDepth(), is(2));
    }

    @Test
    public void deveAlterarAProfundidadeParaMenos2EDepoisPara3() {
        submarine.dive();
        submarine.dive();
        assertThat(submarine.getDepth(), is(-2));

        submarine.surface();
        submarine.surface();
        submarine.surface();
        submarine.surface();
        submarine.surface();
        assertThat(submarine.getDepth(), is(3));
    }
}
