package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.Game;

/**
 * Třída PrikazKonec implementuje pro hru příkaz konec.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */

public class CommandEnd implements ICommand {

    private static final String NAME = "end";

    private Game game;

    /**
     * Konstruktor třídy
     *
     * @param game odkaz na hru, která má být příkazem konec ukončena
     */
    public CommandEnd(Game game) {
        this.game = game;
    }

    /**
     * V případě, že příkaz má jen jedno slovo "konec" hra končí(volá se metoda setKonecHry(true))
     * jinak pokračuje např. při zadání "konec a".
     *
     * @return zpráva, kterou vypíše hra hráči
     */

    @Override
    public String executeCommand(String... parametry) {
        if (parametry.length > 0) {
            return "Ukončit co? Nechápu, proč jste zadal druhé slovo.";
        } else {
            game.setGameEnd(true);
            return "hra ukončena příkazem konec";
        }
    }

    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @ return nazev prikazu
     */
    @Override
    public String getName() {
        return NAME;
    }
}
