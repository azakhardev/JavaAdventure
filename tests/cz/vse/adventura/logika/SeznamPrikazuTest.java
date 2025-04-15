package cz.vse.adventura.logika;

import cz.vse.adventura.logika.commands.CommandGo;
import cz.vse.adventura.logika.commands.CommandEnd;
import cz.vse.adventura.logika.commands.CommandsList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*******************************************************************************
 * Testovací třída SeznamPrikazuTest slouží ke komplexnímu otestování třídy  
 * SeznamPrikazu
 *
 * @author Luboš Pavlíček
 * @version pro školní rok 2016/2017
 */
public class SeznamPrikazuTest {
    private Game game;
    private CommandEnd prKonec;
    private CommandGo prJdi;

    @BeforeEach
    public void setUp() {
        game = new Game();
        prKonec = new CommandEnd(game);
        prJdi = new CommandGo(game.getGamePlan());
    }

    @Test
    public void testVlozeniVybrani() {
        CommandsList seznPrikazu = new CommandsList();
        seznPrikazu.insertCommand(prKonec);
        seznPrikazu.insertCommand(prJdi);
        assertEquals(prKonec, seznPrikazu.returnCommand("konec"));
        assertEquals(prJdi, seznPrikazu.returnCommand("jdi"));
        assertEquals(null, seznPrikazu.returnCommand("nápověda"));
    }

    @Test
    public void testJePlatnyPrikaz() {
        CommandsList seznPrikazu = new CommandsList();
        seznPrikazu.insertCommand(prKonec);
        seznPrikazu.insertCommand(prJdi);
        assertEquals(true, seznPrikazu.isValidCommand("konec"));
        assertEquals(true, seznPrikazu.isValidCommand("jdi"));
        assertEquals(false, seznPrikazu.isValidCommand("nápověda"));
        assertEquals(false, seznPrikazu.isValidCommand("Konec"));
    }

    @Test
    public void testNazvyPrikazu() {
        CommandsList seznPrikazu = new CommandsList();
        seznPrikazu.insertCommand(prKonec);
        seznPrikazu.insertCommand(prJdi);
        String nazvy = seznPrikazu.getCommandsName();
        assertEquals(true, nazvy.contains("konec"));
        assertEquals(true, nazvy.contains("jdi"));
        assertEquals(false, nazvy.contains("nápověda"));
        assertEquals(false, nazvy.contains("Konec"));
    }

}
