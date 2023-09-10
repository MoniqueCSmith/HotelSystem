package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Room;
import za.ac.cput.factory.RoomFactory;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.domain.RoomType.*;
import static za.ac.cput.domain.RoomType.TWIN;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class RoomServiceImplTest {

    @Autowired
    private RoomServiceImpl service;

    private static Room suiteRoom = RoomFactory.buildRoom(SUITE, 600.00);
    private static Room singleRoom = RoomFactory.buildRoom(SINGLE, 1500.00);
    private static Room doubleRoom = RoomFactory.buildRoom(DOUBLE, 2400);
    private static Room queenRoom = RoomFactory.buildRoom(QUEEN, 3000.00);
    private static Room kingRoom = RoomFactory.buildRoom(KING, 4500.00);
    private static Room twinRoom = RoomFactory.buildRoom(TWIN, 1800.00);

    @Test
    void a_create1() {
        Room create = service.create(suiteRoom);
        assertEquals(suiteRoom.getRoomNo(), create.getRoomNo());
        System.out.println("created" + create);
    }
    @Test
    void a_create2() {
        Room create = service.create(singleRoom);
        assertEquals(singleRoom.getRoomNo(), create.getRoomNo());
        System.out.println("created" + create);
    }
    @Test
    void a_create3() {
        Room create = service.create(doubleRoom);
        assertEquals(doubleRoom.getRoomNo(), create.getRoomNo());
        System.out.println("created" + create);
    }
    @Test
    void a_create4() {
        Room create = service.create(queenRoom);
        assertEquals(queenRoom.getRoomNo(), create.getRoomNo());
        System.out.println("created" + create);
    }
    @Test
    void a_create5() {
        Room create = service.create(kingRoom);
        assertEquals(kingRoom.getRoomNo(), create.getRoomNo());
        System.out.println("created" + create);
    }
    @Test
    void a_create6() {
        Room create = service.create(twinRoom);
        assertEquals(twinRoom.getRoomNo(), create.getRoomNo());
        System.out.println("created" + create);
    }


    @Test
    void b_read() {
        Room read = service.read(suiteRoom.getRoomNo());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        Room newRoom = new Room.Builder().copy(suiteRoom).setPrice(6000.00).build();
        Room updated = service.update(newRoom);
        assertEquals(newRoom.getPrice(), updated.getPrice());
        System.out.println("Update" + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = service.delete(suiteRoom.getRoomNo());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}