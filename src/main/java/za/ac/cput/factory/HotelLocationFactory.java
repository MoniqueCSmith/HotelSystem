/* HotelLocationFactory.java
Factory for Hotel Location class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/

package za.ac.cput.factory;


import za.ac.cput.domain.HotelLocation;
import java.util.ArrayList;
import java.util.List;

import static za.ac.cput.util.Helper.generateHotelCode;

public class HotelLocationFactory {
    public static List<HotelLocation> possibleLocations;

    static {
        possibleLocations = new ArrayList<>();

        possibleLocations.add(new HotelLocation.Builder()
                .setHotelCode(generateHotelCode("Western Cape"))
                .setHotelAddress("123 Main Street")
                .setHotelCity("Cape Town")
                .setHotelProvince("Western Cape")
                .setHotelZipCode(8000)
                .build());

        possibleLocations.add(new HotelLocation.Builder()
                .setHotelCode(generateHotelCode("Western Cape"))
                .setHotelAddress("789 Long Street")
                .setHotelCity("Cape Town")
                .setHotelProvince("Western Cape")
                .setHotelZipCode(8001)
                .build());

        possibleLocations.add(new HotelLocation.Builder()
                .setHotelCode(generateHotelCode("Gauteng"))
                .setHotelAddress("456 Main Road")
                .setHotelCity("Johannesburg")
                .setHotelProvince("Gauteng")
                .setHotelZipCode(2000)
                .build());

        possibleLocations.add(new HotelLocation.Builder()
                .setHotelCode(generateHotelCode("Gauteng"))
                .setHotelAddress("101 Oxford Street")
                .setHotelCity("Sandton")
                .setHotelProvince("Gauteng")
                .setHotelZipCode(2196)
                .build());

        possibleLocations.add(new HotelLocation.Builder()
                .setHotelCode(generateHotelCode("Gauteng"))
                .setHotelAddress("15 Market Street")
                .setHotelCity("Johannesburg")
                .setHotelProvince("Gauteng")
                .setHotelZipCode(2001)
                .build());
    }

    public static List<HotelLocation> getPossibleLocations() {
        return possibleLocations;
    }

    public static HotelLocation createHotelLocation(String hotelAddress, String hotelCity,
                                                    String hotelProvince, int hotelZipCode){

        String hotelCode = generateHotelCode(hotelProvince);

        return new HotelLocation.Builder()
                .setHotelCode(hotelCode)
                .setHotelAddress(hotelAddress)
                .setHotelCity(hotelCity)
                .setHotelProvince(hotelProvince)
                .setHotelZipCode(hotelZipCode)
                .build();
    }

}



