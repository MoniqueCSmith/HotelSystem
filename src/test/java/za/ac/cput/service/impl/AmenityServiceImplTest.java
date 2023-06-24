package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Amenity;
import za.ac.cput.util.factory.AmenityFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AmenityServiceImplTest {

    @Autowired
    private AmenityServiceImpl service;

    private static Amenity amenity = AmenityFactory.buildAmenity("Shampoo", "Toiletries", true,12.00);

    @Test
    void a_create() {
        Amenity create = service.create(amenity);
        assertEquals(amenity.getAmenityID(), create.getAmenityID());
        System.out.println("created" + create);
    }

    @Test
    void b_read() {
        Amenity read = service.read(amenity.getAmenityID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        Amenity newAmenity = new Amenity.Builder().copy(amenity).setName("Conditioner").build();
        Amenity updated = service.update(newAmenity);
        assertEquals(newAmenity.getName(), updated.getName());
        System.out.println("Update" + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = service.delete(amenity.getAmenityID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}