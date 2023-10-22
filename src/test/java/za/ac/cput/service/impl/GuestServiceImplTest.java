package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Guest;
import za.ac.cput.factory.GuestFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class GuestServiceImplTest {

    @Autowired
    private GuestServiceImpl service;

    private static Guest guest = GuestFactory.createGuest("Elena", "Gilbert", "1864 Mystic Falls", "0607544654", "elenagilbert@gmail.com");
    @Test
    void a_create() {
        Guest created = service.create(guest);
        assertEquals(guest.getGuestID(), created.getGuestID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Guest read = service.read(guest.getGuestID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Guest newGuest = new Guest.Builder().copy(guest).build();
        Guest updated = service.update(newGuest);
        assertEquals(newGuest.getGuestID(), updated.getGuestID());
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = service.delete(guest.getGuestID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }
}