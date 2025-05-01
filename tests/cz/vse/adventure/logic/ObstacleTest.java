package cz.vse.adventure.logic;

import cz.vse.adventure.logic.Room;
import cz.vse.adventure.logic.commands.UseResult;
import cz.vse.adventure.logic.entities.Obstacle;
import cz.vse.adventure.logic.items.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObstacleTest {

    @Test
    void returnsBlockedRoom() {
        Room room = new Room("Treasure Room", "Shiny and golden");
        Obstacle obstacle = new Obstacle("Locked Door", "It's locked", (item) -> new UseResult("No effect", false), room);
        assertEquals(room, obstacle.getBlockedRoom());
    }

    @Test
    void setsBlockedRoomToNull() {
        Room room = new Room("Vault", "Secure");
        Obstacle obstacle = new Obstacle("Laser Barrier", "Dangerous red light", (item) -> new UseResult("No effect", false), room);
        obstacle.clearPath();
        assertNull(obstacle.getBlockedRoom(), "After clearing path, room should be null");
    }
}
