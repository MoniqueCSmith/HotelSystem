/* HotelLocationFactoryTest.java
Factory test class for Hotel Location
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.HotelLocation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.util.Helper.generateHotelCode;

class HotelLocationFactoryTest {

    private HotelLocation hotelLocation1, hotelLocation2;

    @BeforeEach
    void setUp() {
        hotelLocation1 = new HotelLocation.Builder()
                .setHotelCode(generateHotelCode("Western Cape"))
                .setHotelAddress("123 Main Street")
                .setHotelCity("Cape Town")
                .setHotelProvince("Western Cape")
                .setHotelZipCode(8000)
                .build();

        hotelLocation2 = new HotelLocation.Builder()
                .setHotelCode(generateHotelCode("Gauteng"))
                .setHotelAddress("456 Main Road")
                .setHotelCity("Johannesburg")
                .setHotelProvince("Gauteng")
                .setHotelZipCode(2000)
                .build();
    }

    @Test
    void createHotelLocation() {

        HotelLocation hotelLocation = HotelLocationFactory.createHotelLocation("789 Long Street",
                "Cape Town", "Western Cape", 8001);
        assertNotNull(hotelLocation);


        assertEquals("WES002", hotelLocation.getHotelCode());
        assertEquals("789 Long Street", hotelLocation.getHotelAddress());
        assertEquals("Cape Town", hotelLocation.getHotelCity());
        assertEquals("Western Cape", hotelLocation.getHotelProvince());
        assertEquals(8001, hotelLocation.getHotelZipCode());
    }

    @Test
    void getPossibleLocations() {

        List<HotelLocation> possibleLocations = HotelLocationFactory.getPossibleLocations();
        assertNotNull(possibleLocations);

        assertTrue(possibleLocations.contains(hotelLocation1));
        assertTrue(possibleLocations.contains(hotelLocation2));
        assertEquals(5, possibleLocations.size());
    }
    }

