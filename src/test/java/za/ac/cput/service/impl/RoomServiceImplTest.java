package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Amenity;
import za.ac.cput.domain.Room;
import za.ac.cput.factory.RoomFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class RoomServiceImplTest {
    private static RoomServiceImpl service = RoomServiceImpl.getService();
    private static Room room = RoomFactory.buildRoom("Standard", true);


    @Test
    void a_create() {
        Room created = service.create(room);
        assertEquals(room.getRoomNo(), created.getRoomNo());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Room read = service.read(room);
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Room updated = new Room.Builder().copy(room).setRoomType("Deluxe")
                .setRoomAvailable(false)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void d_delete() {
        boolean success = service.delete(room);
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
