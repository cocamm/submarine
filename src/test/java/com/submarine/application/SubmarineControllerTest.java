package com.submarine.application;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubmarineControllerTest {

    private SubmarineController submarineController;

    @Before
    public void setUp() {
        submarineController = new SubmarineController();
    }

    @Test
    public void deveTestarOsComandos_RMMLMMMDDLL_2_3_menos2_SOUTH() {
        String saida = submarineController.navigate("RMMLMMMDDLL");

        assertThat(saida, is("2 3 -2 SOUTH"));
    }

    @Test
    public void deveTestarOsComandos_RRMRUUMDL_menos1_menos1_1_SOUTH() {
        String saida = submarineController.navigate("RRMRUUMDL");

        assertThat(saida, is("-1 -1 1 SOUTH"));
    }

    @Test
    public void deveAceitarOsComandosComLetraMinuscula() {
        String saida = submarineController.navigate("r");

        assertThat(saida, is("0 0 0 EAST"));
    }

    @Test
    public void deveRetornarErroDeComandoNaoConhecido() {
        String saida = submarineController.navigate("RRz");

        assertThat(saida, is("Comando z nao encontrado!"));
    }

}
