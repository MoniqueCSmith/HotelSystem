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
    void createAmenityToiletries1(){
        Amenity amenity = AmenityFactory.buildAmenity("Shampoo", "Toiletries", true, 25.00);
        assertNotNull(amenity);
        System.out.println(amenity);
    }
    @Test
    void createAmenityToiletries2(){
        Amenity amenity = AmenityFactory.buildAmenity("Conditioner", "Toiletries", true, 25.00);
        assertNotNull(amenity);
        System.out.println(amenity);
    }

    @Test
    void createAmenityToiletries3(){
        Amenity amenity = AmenityFactory.buildAmenity("Lotion", "Toiletries", true, 30.00);
        assertNotNull(amenity);
        System.out.println(amenity);
    }

    @Test
    void createAmenityToiletries4(){
        Amenity amenity = AmenityFactory.buildAmenity("Toothpaste", "Toiletries", true, 20.00);
        assertNotNull(amenity);
        System.out.println(amenity);
    }

    @Test
    void createAmenityElectronics1(){
        Amenity amenity = AmenityFactory.buildAmenity("Blowdryer", "Electronics", true, 20.00);
        assertNotNull(amenity);
        System.out.println(amenity);
    }@Test
    void createAmenityElectronics2(){
        Amenity amenity = AmenityFactory.buildAmenity("Flat Iron", "Electronics", true, 20.00);
        assertNotNull(amenity);
        System.out.println(amenity);
    }

}