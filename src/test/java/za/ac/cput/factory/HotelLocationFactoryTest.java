/* HotelLocationFactoryTest.java
Factory test class for Hotel Location
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.HotelLocation;

import static org.junit.jupiter.api.Assertions.*;

class HotelLocationFactoryTest {

    @Test
    void createHotelLocation(){
        HotelLocation hotelLocation= HotelLocationFactory.createHotelLocation("32 Burger Street Camps Bay", "Cape Town", "Western Cape", 7301, "0215900310");
        assertNotNull(hotelLocation);
        System.out.println(hotelLocation);
        }
    }

