package cz.vse.adventure.logic;


import cz.vse.adventure.logic.entities.Obstacle;
import cz.vse.adventure.logic.entities.Prop;
import cz.vse.adventure.logic.items.Item;

import java.util.Scanner;
import java.util.function.Function;

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
     *
     */
    public GamePlan() {
        setupRooms();
    }

    /**
     *
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

        Item fuse = new Item("fuse", "A small, cylindrical piece of metal with a glass window at the center. It looks like something that would restore power to the electrical systems, perhaps to the lights or machinery.", 2);
        Item crowbar = new Item("crowbar", "A heavy-duty metal tool with a curved, flattened end. It looks worn from use, but still strong enough to pry open doors, crates, or anything that’s stubbornly stuck.", 4);
        Item acid = new Item("acid", "A small bottle of highly corrosive liquid, with a faint greenish glow. It hisses whenever disturbed, a dangerous substance capable of eating through organic matter with ease.", 2);
        Item dynamite = new Item("dynamite", "A bundle of explosive sticks wrapped in paper, with a fuse sticking out. The unmistakable smell of gunpowder lingers around it. A sure way to clear any large obstructions—if you’re brave enough to use it.", 3);
        Item needle = new Item("needle", "A slender, slightly bent sewing needle. Still sharp enough to stitch something together—if you have thread or cloth.", 1);
        Item smallKey = new Item("key", "A tiny brass key, old and tarnished, but sturdy. It seems to fit a very specific lock — perhaps a drawer or cabinet that’s holding something valuable.", 1);
        Item wrench = new Item("wrench", "An old wrench, covered in rust and grime. The handle is worn from years of use, but the wrench’s solid, heavy build makes it perfect for fixing or dismantling old machinery.", 3);
        Item plant = new Item("plant", "A small vial containing a strange plant sample. Its leaves are thick and waxy, and it has an unnatural glow when examined closely. Could it be the key to unlocking something else in the environment", 1);
        Item journal1 = new Item("journal_page1", "A yellowed sheet of paper, torn at the edges. The ink is smudged, but legible. It seems to describe strange happenings, possibly connected to the vault or the building’s mysterious history.", 0);
        Item journal2 = new Item("journal_page2", "Another page from the journal, faded but still readable. It offers more clues about the vault, along with cryptic notes that suggest a deeper mystery.", 0);
        Item matches = new Item("matches", "A small box of matches, their tips dark and ready to strike. They’re useful for lighting candles, lamps, or anything that has to be lit.", 1);
        Item shovel = new Item("shovel", "A rusty, heavy shovel with a worn wooden handle. The metal is chipped from years of digging, but it’s still sharp enough to dig through loose soil or break through debris.", 5);
        Item tape = new Item("tape", "A roll of thick, sticky tape. It looks like it could fix broken cables, seams, or even secure loose items together. There’s an odd residue on the sticky side, making it seem like it has seen better days.", 2);
        Item bottle = new Item("bottle", "A small glass bottle, its edges smooth and clear. It’s empty now, but could easily hold liquid. It’s perfect for transporting the dangerous acid without spilling it.", 3);
        Item cutters = new Item("wire_cutters", "A pair of wire cutters, with sharp, rusted edges. The handles are scuffed from years of use, but the tool is still functional and could easily snip through thick cables or wires.", 3);
        Item cloth = new Item("cloth", "A torn piece of durable fabric, maybe from an old lab coat or curtain. Could be useful for patching or crafting.", 1);
        Item cable = new Item("broken_cable", "A snapped power cable with frayed wires at both ends. Sparks occasionally flicker from the exposed metal.", 2);

        Function<Item, String> used = (item) -> "You have already used an item on this object";

        Prop toilet = new Prop("toilet_bowl", "Disgusting, but suspiciously clean inside", () -> "You reach in (gross), but you didn't find anything.");
        Prop mirror = new Prop("mirror", "A wall mirror, cracked down the middle, reflecting a distorted version of you.", () -> "You stare at your warped reflection.");
        Prop locker = new Prop("locker", "A dented locker with chipped paint and a rusted handle.", () -> "You need some sort of key to open it.");
        locker.setOnUse((item) -> {
            if (item.getName().equals("key")) {
                barrack.addItem(new Item("locker_note", "Text here", 0));
                locker.setOnInteract(() -> "The locker that you have unlocked a while ago.");
                locker.setOnUse(used);
                return "You've succesfully opened a locker";
            }
            return "This doesn't fit into the lock.";
        });

        Prop drawer = new Prop("oven_drawer", "A filthy oven drawer jammed halfway, something rattling inside.", () -> {
            kitchen.addItem(new Item("knife", "Old but sharp. Could be useful for cutting cables or defending yourself.", 2));
            return "You yank it open with effort. You see a knife inside.";
        });
        Prop pans = new Prop("pans", "Rusted metal pans dangle from hooks, swaying gently despite no wind.", () -> "You accidentally knock one. The clang echoes.");
        Prop fridge = new Prop("fridge", "An ancient refrigerator humming faintly, its door slightly ajar.", () -> "You peek inside and quickly regret it.");

        Prop box = new Prop("box", " A dusty cardboard box sitting just out of reach on a steel shelf.", () -> {
            storage.addItem(new Item("screwdriver", "Flathead tool. Can remove panels or open crates.", 2));
            return "There is something inside the box.";
        });


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
            if (!item.getName().equals("acid_bottle")) {
                return "You can't use this item to burn the thick plants.";
            }
            outpost.getObstacles().remove("overgrown_plants");
            return "You pour the corrosive mix onto the thick vines. They hiss and writhe before dissolving into a foul-smelling sludge. The path clears slowly, revealing the corridor beyond.";
        }, catacombs);
        Obstacle fallenRocks = new Obstacle("fallen_rocks", "A pile of large fallen rocks is blocking the path to the shafts.",
                (item) -> {
                    if (!item.getName().equals("primed_explosive")) {
                        return "You can't use this item on pile of rocks... It won't do much to it...";
                    }
                    outpost.getObstacles().remove("fallen_rocks");
                    return "You strike a match and light the fuse. You step back. A deep rumble follows... BOOM. The passage is clear.";
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
        barrack.addProp(toilet);
        barrack.addProp(mirror);
        barrack.addProp(locker);
        barrack.addItem(needle);
        kitchen.setExit(barrack);
        kitchen.addItem(smallKey);
        kitchen.addProp(pans);
        kitchen.addProp(drawer);
        kitchen.addProp(fridge);
        kitchen.setExit(storage);
        kitchen.setExit(hallway);
        kitchen.addObstacle(fuseBox);
        storage.setExit(kitchen);
        storage.setExit(office);
        storage.addItem(fuse);
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
        shaft.addItem(crowbar);
        laboratory.setExit(outpost);
        laboratory.setExit(armory);
        laboratory.addItem(acid);
        armory.setExit(laboratory);
        armory.addItem(dynamite);
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
