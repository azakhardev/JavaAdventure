package cz.vse.adventura.logika;


/**
 * Class HerniPlan - třída představující mapu a stav adventury.
 * <p>
 * Tato třída inicializuje prvky ze kterých se hra skládá:
 * vytváří všechny prostory,
 * propojuje je vzájemně pomocí východů
 * a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */
public class GamePlan {

    private Room aktualniRoom;

    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public GamePlan() {
        zalozProstoryHry();

    }

    /**
     * Vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Room domecek = new Room("domeček", "domeček, ve kterém bydlí Karkulka");
        Room chaloupka = new Room("chaloupka", "chaloupka, ve které bydlí babička Karkulky");
        Room jeskyne = new Room("jeskyně", "stará plesnivá jeskyně");
        Room les = new Room("les", "les s jahodami, malinami a pramenem vody");
        Room hlubokyLes = new Room("hluboký_les", "temný les, ve kterém lze potkat vlka");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        domecek.setExit(les);
        les.setExit(domecek);
        les.setExit(hlubokyLes);
        hlubokyLes.setExit(les);
        hlubokyLes.setExit(jeskyne);
        hlubokyLes.setExit(chaloupka);
        jeskyne.setExit(hlubokyLes);
        chaloupka.setExit(hlubokyLes);

        aktualniRoom = domecek;  // hra začíná v domečku
    }

    /**
     * Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     * @return aktuální prostor
     */

    public Room getAktualniProstor() {
        return aktualniRoom;
    }

    /**
     * Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     * @param room nový aktuální prostor
     */
    public void setAktualniProstor(Room room) {
        aktualniRoom = room;
    }

}
