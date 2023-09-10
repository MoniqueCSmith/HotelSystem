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
    void createAmentities(){
        Amenity amenity1 = AmenityFactory.buildAmenity("Shampoo", "Toiletries", true, 25.00);
        assertNotNull(amenity1);
        System.out.println(amenity1);

        Amenity amenity2 = AmenityFactory.buildAmenity("Conditioner", "Toiletries", true, 25.00);
        assertNotNull(amenity2);
        System.out.println(amenity2);

        Amenity amenity3 = AmenityFactory.buildAmenity("Lotion", "Toiletries", true, 30.00);
        assertNotNull(amenity3);
        System.out.println(amenity3);

        Amenity amenity4 = AmenityFactory.buildAmenity("Toothpaste", "Toiletries", true, 20.00);
        assertNotNull(amenity4);
        System.out.println(amenity4);

        Amenity amenity5 = AmenityFactory.buildAmenity("Blowdryer", "Electronics", true, 20.00);
        assertNotNull(amenity5);
        System.out.println(amenity5);

        Amenity amenity6 = AmenityFactory.buildAmenity("Flat Iron", "Electronics", true, 20.00);
        assertNotNull(amenity6);
        System.out.println(amenity6);
    }

}