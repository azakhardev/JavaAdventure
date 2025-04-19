package cz.vse.adventure.logic;

import cz.vse.adventure.logic.commands.*;
import cz.vse.adventure.logic.entities.Player;
import cz.vse.adventure.logic.items.Backpack;

/**
 * Třída Hra - třída představující logiku adventury.
 * <p>
 * Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 * a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 * Vypisuje uvítací a ukončovací text hry.
 * Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */

public class Game implements IGame {
    private CommandsList validCommands;    // obsahuje seznam přípustných příkazů
    private GamePlan gamePlan;
    private boolean gameEnd = false;
    private Player player;

    /**
     * Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Game() {
        player = new Player(new Backpack(6));
        gamePlan = new GamePlan();
        validCommands = new CommandsList();
        validCommands.insertCommand(new CommandHelp(validCommands));
        validCommands.insertCommand(new CommandGo(gamePlan));
        validCommands.insertCommand(new CommandEnd(this));
        validCommands.insertCommand(new CommandInventory(this.player));
        validCommands.insertCommand(new CommandDescription(gamePlan));
    }

    /**
     * Vrátí úvodní zprávu pro hráče.
     */

    public String getGreeting() {
        return "Welcome!\n" +
                "This is a story about lost man in abondoned facility, who doesn't remember his past.\n" +
                "Write 'help', if you don't know how to play\n" +
                "\n" +
                gamePlan.getCurrentRoom().getLongDescription();
    }

    /**
     * Vrátí závěrečnou zprávu pro hráče.
     */
    public String getEpilogue() {
        return "Dík, že jste si zahráli.  Ahoj.";
    }

    /**
     * Vrací true, pokud hra skončila.
     */
    public boolean isGameEnded() {
        return gameEnd;
    }

    /**
     * Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     * Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     * Pokud ano spustí samotné provádění příkazu.
     *
     * @param radek text, který zadal uživatel jako příkaz do hry.
     * @return vrací se řetězec, který se má vypsat na obrazovku
     */
    public String processCommand(String radek) {
        String[] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String[] parametry = new String[slova.length - 1];
        for (int i = 0; i < parametry.length; i++) {
            parametry[i] = slova[i + 1];
        }
        String textKVypsani = " .... ";
        if (validCommands.isValidCommand(slovoPrikazu)) {
            ICommand prikaz = validCommands.returnCommand(slovoPrikazu);
            textKVypsani = prikaz.executeCommand(parametry);
        } else {
            textKVypsani = "Nevím co tím myslíš? Tento příkaz neznám. ";
        }
        return textKVypsani;
    }


    /**
     * Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     * mohou ji použít i další implementace rozhraní Prikaz.
     *
     * @param gameEnd hodnota false= konec hry, true = hra pokračuje
     */
    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    /**
     * Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     * kde se jejím prostřednictvím získává aktualní místnost hry.
     *
     * @return odkaz na herní plán
     */
    public GamePlan getGamePlan() {
        return gamePlan;
    }

}

