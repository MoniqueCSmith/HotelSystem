/**
 * AmenityFactory.java
 * Factory class for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Amenity;
import za.ac.cput.util.Helper;

public class AmenityFactory {

    public static Amenity buildAmenity(String amenityName, String amenityDesc,
                                       Boolean isAmenityAvailable,Double amenityPrice){

        if(Helper.isNullOrEmpty(amenityName) || Helper.isNullOrEmpty(amenityDesc) ||
                Helper.isNullOrEmpty(String.valueOf(isAmenityAvailable)) ||
                Helper.isNullOrEmpty(String.valueOf(amenityPrice))) {
            return null;
        }

        String amenityID = Helper.generateID();

        return new Amenity.Builder()
                .setAmenityID(amenityID)
                .setAmenityName(amenityName)
                .setAmenityDesc(amenityDesc)
                .setAmenityAvailable(isAmenityAvailable)
                .setAmenityPrice(amenityPrice)
                .build();
    }
}
