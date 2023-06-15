/**
 * RoomRepositoryTest.java
 * Repository Test for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import za.ac.cput.domain.Room;
import za.ac.cput.factory.RoomFactory;
import za.ac.cput.repository.impl.RoomRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class RoomRepositoryImplTest {
    private static RoomRepositoryImpl repository = RoomRepositoryImpl.getRepository();
    private static Room room = RoomFactory.buildRoom("Standard", true);

    @Test
    void a_create() {
        Room created = repository.create(room);
        assertEquals(room.getRoomNo(), created.getRoomNo());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Room read = repository.read(room.getRoomNo());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Room updated = new Room.Builder().copy(room).setRoomType("Deluxe")
                .setRoomAvailable(false)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(room.getRoomNo());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}
