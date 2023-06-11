/* HotelLocationServiceImplTest.java
 Service Test for the HotelLocationServiceImpl class
 Author: Ashton Williams (220468478)
 Date: 10 June 2023
*/
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.HotelLocation;
import za.ac.cput.factory.HotelLocationFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class HotelLocationServiceImplTest {

    private static HotelLocationServiceImpl service= HotelLocationServiceImpl.getService();
    private static HotelLocation hotelLocation= HotelLocationFactory.createHotelLocation("79 Broo Street Milnerton","Cape Town", "Western Cape", 7682);

    @Test
    void a_create() {
        HotelLocation created1= service.create(hotelLocation);
        assertEquals(hotelLocation.getID(), created1.getID());
        System.out.println("This object has been created: " + created1);
    }

    @Test
    void b_read() {
        HotelLocation read= service.read(hotelLocation);
        assertNotNull(read);
        System.out.println("This has been read: " + read);
    }

    @Test
    void c_update() {
        HotelLocation updated= new HotelLocation.Builder().copy(hotelLocation)
                .setAddress("20 Builder Street Milnerton")
                .setCity("Cape Town")
                .setProvince("Western Cape")
                .setZipCode(7392)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("The updated hotel location is: " + updated);
    }

    @Test
    void d_delete() {
        boolean success= service.delete(hotelLocation);
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Display all information");
        System.out.println(service.getAll());
    }
}