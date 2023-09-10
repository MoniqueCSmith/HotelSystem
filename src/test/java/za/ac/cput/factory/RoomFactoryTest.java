/**
 * RoomFactoryTest.java
 * Factory Test for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Room;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.domain.RoomType.*;
import static za.ac.cput.domain.RoomType.TWIN;

class RoomFactoryTest {

    @Test
    void createRooms() {
        Room suiteRoom = RoomFactory.buildRoom(SUITE, 6000.00);
        assertNotNull(suiteRoom);
        System.out.println(suiteRoom);

        Room singleRoom = RoomFactory.buildRoom(SINGLE, 1500.00);
        assertNotNull(singleRoom);
        System.out.println(singleRoom);

        Room doubleRoom = RoomFactory.buildRoom(DOUBLE, 2400.00);
        assertNotNull(doubleRoom);
        System.out.println(doubleRoom);

        Room queenRoom = RoomFactory.buildRoom(QUEEN, 3000.00);
        assertNotNull(queenRoom);
        System.out.println(queenRoom);

        Room kingRoom = RoomFactory.buildRoom(KING, 4500.00);
        assertNotNull(kingRoom);
        System.out.println(kingRoom);

        Room twinRoom = RoomFactory.buildRoom(TWIN, 1800.00);
        assertNotNull(twinRoom);
        System.out.println(twinRoom);

    }
}