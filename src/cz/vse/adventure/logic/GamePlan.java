package cz.vse.adventure.logic;


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

    private Room currentRoom;

    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public GamePlan() {
        setupRooms();
    }

    /**
     * Vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví domeček.
     */
    private void setupRooms() {
        // vytvářejí se jednotlivé prostory
        Room barrack = new Room("barrack", "Your starting point. A simple room with beds and lockers once used by the facility’s staff.");
        Room kitchen = new Room("kitchen", "Dusty counters, rusted utensils, and the smell of something long forgotten.");
        Room storage = new Room("storage", "Old boxes, broken crates, and cobwebs. Maybe there’s still something useful left.");
        Room office = new Room("office", "Scattered papers and flickering lights. Someone left in a hurry.");
        Room hallway = new Room("hallway", "A dim corridor connecting various parts of the facility. Echoes make you feel uneasy.");
        Room greenhouse = new Room("greenhouse", "Overgrown plants have taken control. Nature is reclaiming its space.");
        Room engineRoom = new Room("engine_room", "Heavy machinery and tangled wires. Something here is still humming");
        Room serverRoom = new Room("server_room", "Cold and silent. Racks of old servers blink with a strange rhythm.");
        Room administration = new Room("administration", "A central control station with a blinking console. Perhaps you can access security here.");
        Room outpost = new Room("outpost", "An elevated station with a clear view of the surroundings. Once used to keep things in... or out.");
        Room catacombs = new Room("catacombs", "Dark tunnels beneath the facility. The air is thick, and the silence is deafening.");
        Room shaft = new Room("shaft", "A deep vertical tunnel with a broken lift. Getting down won’t be easy.");
        Room laboratory = new Room("lab", "Beakers, notes, and strange equipment. Experiments were conducted here... questionable ones.");
        Room armory = new Room("armory", " Locked cases and weapon racks. If only you had the right key...");


        // přiřazují se průchody mezi prostory (sousedící prostory)
        barrack.setExit(kitchen);
        kitchen.setExit(barrack);
        kitchen.setExit(storage);
        kitchen.setExit(hallway);
        storage.setExit(kitchen);
        storage.setExit(office);
        office.setExit(storage);
        hallway.setExit(kitchen);
        hallway.setExit(greenhouse);
        greenhouse.setExit(hallway);
        greenhouse.setExit(engineRoom);
        greenhouse.setExit(outpost);
        engineRoom.setExit(greenhouse);
        engineRoom.setExit(serverRoom);
        serverRoom.setExit(engineRoom);
        serverRoom.setExit(administration);
        outpost.setExit(greenhouse);
        outpost.setExit(catacombs);
        outpost.setExit(shaft);
        outpost.setExit(laboratory);
        catacombs.setExit(outpost);
        shaft.setExit(outpost);
        laboratory.setExit(outpost);
        laboratory.setExit(armory);
        armory.setExit(laboratory);

        currentRoom = barrack;  // hra začíná v domečku
    }

    /**
     * Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     * @return aktuální prostor
     */

    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     * @param room nový aktuální prostor
     */
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
}
