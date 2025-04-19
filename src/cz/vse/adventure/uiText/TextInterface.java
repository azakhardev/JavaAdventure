package cz.vse.adventure.uiText;


import java.util.Scanner;

import cz.vse.adventure.logic.IGame;

/**
 * Class TextoveRozhrani
 * <p>
 * Toto je uživatelského rozhraní aplikace Adventura
 * Tato třída vytváří instanci třídy Hra, která představuje logiku aplikace.
 * Čte vstup zadaný uživatelem a předává tento řetězec logice a vypisuje odpověď logiky na konzoli.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */

public class TextInterface {
    private IGame game;

    /**
     * Vytváří hru.
     */
    public TextInterface(IGame game) {
        this.game = game;
    }

    /**
     * Hlavní metoda hry. Vypíše úvodní text a pak opakuje čtení a zpracování
     * příkazu od hráče do konce hry (dokud metoda konecHry() z logiky nevrátí
     * hodnotu true). Nakonec vypíše text epilogu.
     */
    public void play() {
        System.out.println(game.getGreeting());
        // základní cyklus programu - opakovaně se čtou příkazy a poté
        // se provádějí do konce hry.

        while (!game.isGameEnded()) {
            String line = readString();
            System.out.println(game.processCommand(line));
        }

        System.out.println(game.getEpilogue());
    }

    /**
     * Metoda přečte příkaz z příkazového řádku
     *
     * @return Vrací přečtený příkaz jako instanci třídy String
     */
    private String readString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextLine();
    }

}
