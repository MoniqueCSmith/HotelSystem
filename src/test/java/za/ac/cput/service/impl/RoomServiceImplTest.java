package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Room;
import za.ac.cput.util.factory.RoomFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class RoomServiceImplTest {

    @Autowired
    private RoomServiceImpl service;

    private static Room room = RoomFactory.buildRoom("Standard", true);

    @Test
    void a_create() {
        Room create = service.create(room);
        assertEquals(room.getRoomNo(), create.getRoomNo());
        System.out.println("created" + create);
    }

    @Test
    void b_read() {
        Room read = service.read(room.getRoomNo());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        Room newRoom = new Room.Builder().copy(room).setRoomType("Double").build();
        Room updated = service.update(newRoom);
        assertEquals(newRoom.getRoomType(), updated.getRoomType());
        System.out.println("Update" + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = service.delete(room.getRoomNo());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}