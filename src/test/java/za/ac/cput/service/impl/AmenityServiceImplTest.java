/**
 * AmenityServiceTest.java
 * Service Test for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Amenity;
import za.ac.cput.factory.AmenityFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
public class AmenityServiceImplTest {

    private static AmenityServiceImpl service = AmenityServiceImpl.getService();
    private static Amenity amenity = AmenityFactory.buildAmenity("Conditioner","Toiletries", true, 25.00);

    @Test
    void a_create() {
        Amenity created1 = service.create(amenity);
        assertEquals(amenity.getAmenityID(), created1.getAmenityID());
        System.out.println("Create:" + created1);
    }

    @Test
    void b_read() {
        Amenity read = service.read(amenity.getAmenityID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Amenity updated = new Amenity.Builder().copy(amenity).setName("Pads")
                .setDescription("Toiletries")
                .setAmenityAvailable(false)
                .setPrice(10.00)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void d_delete() {
        boolean success = service.delete(amenity.getAmenityID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
