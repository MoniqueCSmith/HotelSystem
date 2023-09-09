package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Amenity;
import za.ac.cput.factory.AmenityFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AmenityServiceImplTest {

    @Autowired
    private AmenityServiceImpl service;

    private static Amenity amenity1 = AmenityFactory.buildAmenity("Shampoo", "Toiletries", true, 25.00);
    private static Amenity amenity2 = AmenityFactory.buildAmenity("Condtioner", "Toiletries", true, 25.00);
    private static Amenity amenity3 = AmenityFactory.buildAmenity("Lotion", "Toiletries", true, 30.00);
    private static Amenity amenity4 = AmenityFactory.buildAmenity("Toothpaste", "Toiletries", true, 20.00);
    private static Amenity amenity5 = AmenityFactory.buildAmenity("Blow-dryer", "Electronics", true, 20.00);
    private static Amenity amenity6 = AmenityFactory.buildAmenity("Flat Iron", "Electronics", true, 20.00);
    @Test
    void a_create1() {
        Amenity create = service.create(amenity1);
        assertEquals(amenity1.getAmenityID(), create.getAmenityID());
        System.out.println("created" + create);
    }
    @Test
    void a_create2() {
        Amenity create = service.create(amenity2);
        assertEquals(amenity2.getAmenityID(), create.getAmenityID());
        System.out.println("created" + create);
    }
    @Test
    void a_create3() {
        Amenity create = service.create(amenity3);
        assertEquals(amenity3.getAmenityID(), create.getAmenityID());
        System.out.println("created" + create);
    }
    @Test
    void a_create4() {
        Amenity create = service.create(amenity4);
        assertEquals(amenity4.getAmenityID(), create.getAmenityID());
        System.out.println("created" + create);
    }
    @Test
    void a_create5() {
        Amenity create = service.create(amenity5);
        assertEquals(amenity5.getAmenityID(), create.getAmenityID());
        System.out.println("created" + create);
    }
    @Test
    void a_create6() {
        Amenity create = service.create(amenity6);
        assertEquals(amenity6.getAmenityID(), create.getAmenityID());
        System.out.println("created" + create);
    }
    @Test
    void b_read() {
        Amenity read = service.read(amenity1.getAmenityID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        Amenity newAmenity = new Amenity.Builder().copy(amenity1).setName("Conditioner").build();
        Amenity updated = service.update(newAmenity);
        assertEquals(newAmenity.getName(), updated.getName());
        System.out.println("Update" + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = service.delete(amenity1.getAmenityID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}