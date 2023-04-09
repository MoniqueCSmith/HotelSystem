/**
 * AmenityFactoryTest.java
 * Factory Test for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Amenity;

import static org.junit.jupiter.api.Assertions.*;

class AmenityFactoryTest {
    @Test
    void createAmenity(){
        Amenity amenity = AmenityFactory.buildAmenity("hair dyer", "Personal Care", true, 50.00);
        assertNotNull(amenity);
        System.out.println(amenity);
    }

}