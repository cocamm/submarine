package com.submarine.command.translator;

import com.submarine.SubmarineTestSetup;

import com.submarine.command.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class SubmarineTranslatorTest extends SubmarineTestSetup {

    private SubmarineCommandTranslator translator;

    @Before
    public void setUp() {
        translator = new DefaultSubmarineCommandTranslator(submarine);
    }

    @Test
    public void criarUmNovoTradutorDeComandos() {
        assertNotNull(translator);
    }

    @Test
    public void deveRetornarUmaListaDeComandosComUmComando() {
        List<SubmarineCommand> submarineCommands = translator.translate("R");

        assertThat(submarineCommands.size(), is(1));
    }

    @Test(expected = CommandNotFoundException.class)
    public void deveRetornarCommandNotFoundExceptionQuandoPassarUmComandoInvalido() {
        List<SubmarineCommand> submarineCommands = translator.translate("Z");
    }

    @Test
    public void deveRetornarUmaListaDeComandosComUmComandoLeftEUmComandoRight() {
        List<SubmarineCommand> submarineCommands = translator.translate("LR");

        assertThat(submarineCommands.size(), is(2));
        assertThat(submarineCommands.get(0), instanceOf(RotateLeftCommand.class));
        assertThat(submarineCommands.get(1), instanceOf(RotateRightCommand.class));
    }

    @Test
    public void deveRetornarUmaListaDeComandosComUmComandoMoveEUmComandoUp() {
        List<SubmarineCommand> submarineCommands = translator.translate("MU");

        assertThat(submarineCommands.size(), is(2));
        assertThat(submarineCommands.get(0), instanceOf(MoveCommand.class));
        assertThat(submarineCommands.get(1), instanceOf(UpCommand.class));
    }

    @Test
    public void deveRetornarUmaListaDeComandosValidos_LRMUD() {
        List<SubmarineCommand> submarineCommands = translator.translate("LRMUD");

        assertThat(submarineCommands.size(), is(5));
        assertThat(submarineCommands.get(0), instanceOf(RotateLeftCommand.class));
        assertThat(submarineCommands.get(1), instanceOf(RotateRightCommand.class));
        assertThat(submarineCommands.get(2), instanceOf(MoveCommand.class));
        assertThat(submarineCommands.get(3), instanceOf(UpCommand.class));
        assertThat(submarineCommands.get(4), instanceOf(DownCommand.class));
    }
}
