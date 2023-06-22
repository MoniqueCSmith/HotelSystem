/**
 * RoomFactoryTest.java
 * Factory Test for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Room;
import za.ac.cput.util.factory.RoomFactory;

import static org.junit.jupiter.api.Assertions.*;

class RoomFactoryTest {

    @Test
    void createRoom(){
        Room room = RoomFactory.buildRoom("Standard", true);
        assertNotNull(room);
        System.out.println(room);

    }
}