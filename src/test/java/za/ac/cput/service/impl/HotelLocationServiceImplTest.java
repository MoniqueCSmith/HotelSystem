package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.HotelLocation;
import za.ac.cput.factory.HotelLocationFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class HotelLocationServiceImplTest {

    @Autowired
    private HotelLocationServiceImpl service;

    private static HotelLocation hotelLocation= HotelLocationFactory.createHotelLocation("6 Nassau Street Milnerton", "Cape Town", "Western Cape",7441,"0213907901");

    @Test
    void a_create() {
        HotelLocation created = service.create(hotelLocation);
        assertEquals(hotelLocation.getID(), created.getID());
        System.out.println("This has been created: " + created);
    }

    @Test
    void b_read() {
        HotelLocation read= service.read(hotelLocation.getID());
        assertNotNull(read);
        System.out.println("This has been read: " + read);
    }

    @Test
    void c_update() {
        HotelLocation newHotelLocation= new HotelLocation.Builder().copy(hotelLocation)
                .setZipCode(7341)
                .build();
        HotelLocation updated= service.update(newHotelLocation);
        assertEquals(newHotelLocation.getZipCode(), updated.getZipCode());
        System.out.println("This has been updated" + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success= service.delete(hotelLocation.getID());
        assertTrue(success);
        System.out.println("Files have been deleted." + success);
    }

    @Test
    void e_getAll() {
        System.out.println("This is what has been fetched:");
        System.out.println(service.getAll());
    }
}