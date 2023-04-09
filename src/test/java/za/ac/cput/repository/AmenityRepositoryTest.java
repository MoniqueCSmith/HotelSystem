/**
 * AmenityRepositoryTest.java
 * Repository Test for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Amenity;
import za.ac.cput.factory.AmenityFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AmenityRepositoryTest {

    private static AmenityRepository repository = AmenityRepository.getRepository();
    private static Amenity amenity = AmenityFactory.buildAmenity("Shampoo","Toiletries", true, 20.00);

    @Test
    void a_create() {
        Amenity created = repository.create(amenity);
        assertEquals(amenity.getAmenityID(), created.getAmenityID());
        System.out.println("Create:" + created);
    }
    @Test
    void b_read() {
        Amenity read = repository.read(amenity.getAmenityID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }
    @Test
    void c_update() {
        Amenity updated = new Amenity.Builder().copy(amenity).setAmenityName("Conditioner")
                .setAmenityDesc("Toiletries")
                .setAmenityAvailable(false)
                .setAmenityPrice(20.00)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }
    @Test
    void d_delete() {
        boolean success = repository.delete(amenity.getAmenityID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }
    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}