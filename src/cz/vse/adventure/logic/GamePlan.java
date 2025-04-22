package cz.vse.adventure.logic;


import cz.vse.adventure.logic.entities.Obstacle;
import cz.vse.adventure.logic.items.Item;

import java.util.Scanner;

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
        Room exitRoom = new Room("exit", "The exit room.");

        Item fuse = new Item("fuse", "Old fuse, but still funcitonal. Can be handy.", 1);
        Item rock = new Item("rock", "Giant rock, you can't pick it up", 7);

        Obstacle fuseBox = new Obstacle("fuse_box",
                "An old metal fuse box mounted to the wall. The cover hangs slightly ajar, and inside, one of the fuse slots is empty. Without it, the corridor remains dark and lifeless.",
                (item) -> {
                    if (!item.getName().equals("fuse")) {
                        return "You can't use this item on the fuse box.";
                    }
                    kitchen.getObstacles().remove("fuse_box");
                    return "You flipped the fuse. The hallway is now lit.";
                }, hallway);
        Obstacle stuckDoor = new Obstacle("stuck_door", "The door is jammed and won't budge. Maybe a crowbar could help.", (item) -> {
            if (!item.getName().equals("crowbar")) {
                return "You can't use this item to pry the door open.";
            }
            greenhouse.getObstacles().remove("stuck_door");
            return "With a sharp creak and a burst of force, the crowbar pries the door loose. The way ahead is now open, though the hinges will never be the same.";
        }, engineRoom);
        Obstacle overgrownPlants = new Obstacle("overgrown_plants", "Thick, overgrown plants block your way. They're too dense to move through.", (item) -> {
            if (!item.getName().equals("acid")) {
                return "The item has no effect on the thick plants.";
            }
            outpost.getObstacles().remove("overgrown_plants");
            return "You pour the corrosive mix onto the thick vines. They hiss and writhe before dissolving into a foul-smelling sludge. The path clears slowly, revealing the corridor beyond.";
        }, catacombs);
        Obstacle fallenRocks = new Obstacle("fallen_rocks", "A pile of large fallen rocks is blocking the path to the shafts.",
                (item) -> {
                    if (!item.getName().equals("dynamite")) {
                        return "This won't do much to a pile of rocks...";
                    }
                    outpost.getObstacles().remove("fallen_rocks");
                    return "You light the fuse and take cover. The explosion echoes through the cavern, and when the dust settles, the blockage is gone—replaced by rubble and a newly cleared path.";
                }, shaft);
        Obstacle vaultDoor = new Obstacle("vault_door", "A massive vault door bars your way. There's a numeric keypad next to it.", (item) -> {
            System.out.println("Please, enter the code:");

            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("1234")) {
                administration.getObstacles().remove("stuck_door");
                return "The keypad beeps in approval. Heavy mechanisms shift behind the steel as the vault door unlocks with a deep, resonant thud. You are finally free from this long forgotten maze...";
            }

            return "The password is wrong.";
        }, exitRoom);

        // přiřazují se průchody mezi prostory (sousedící prostory)
        barrack.setExit(kitchen);
        barrack.addItem(fuse);
        barrack.addItem(rock);
        kitchen.setExit(barrack);
        kitchen.setExit(storage);
        kitchen.setExit(hallway);
        kitchen.addObstacle(fuseBox);
        storage.setExit(kitchen);
        storage.setExit(office);
        office.setExit(storage);
        hallway.setExit(kitchen);
        hallway.setExit(greenhouse);
        greenhouse.setExit(hallway);
        greenhouse.setExit(engineRoom);
        greenhouse.setExit(outpost);
        greenhouse.addObstacle(stuckDoor);
        engineRoom.setExit(greenhouse);
        engineRoom.setExit(serverRoom);
        serverRoom.setExit(engineRoom);
        serverRoom.setExit(administration);
        administration.setExit(serverRoom);
        administration.setExit(exitRoom);
        administration.addObstacle(vaultDoor);
        outpost.setExit(greenhouse);
        outpost.setExit(catacombs);
        outpost.setExit(shaft);
        outpost.setExit(laboratory);
        outpost.addObstacle(overgrownPlants);
        outpost.addObstacle(fallenRocks);
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
