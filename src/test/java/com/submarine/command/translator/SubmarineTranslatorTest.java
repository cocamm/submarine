package com.submarine.command.translator;

import com.submarine.SubmarineTestSetup;

import com.submarine.command.CommandNotFoundException;
import com.submarine.command.SubmarineCommand;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void deveRetornarUmListaDeComandosComUmComando() {
        List<SubmarineCommand> submarineCommands = translator.translate("R");

        assertThat(submarineCommands.size(), is(1));
    }

    @Test(expected = CommandNotFoundException.class)
    public void deveRetornarCommandNotFoundExceptionQuandoPassarUmComandoInvalido() {
        List<SubmarineCommand> submarineCommands = translator.translate("Z");
    }
}
