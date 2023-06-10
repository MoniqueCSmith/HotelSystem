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

    public static Amenity buildAmenity(String name, String description,
                                       Boolean isAmenityAvailable,Double price){

        if(Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description) ||
                Helper.isNullOrEmpty(String.valueOf(isAmenityAvailable)) ||
                Helper.isNullOrEmpty(String.valueOf(price))) {
            return null;
        }

        String amenityID = Helper.generateID();

        return new Amenity.Builder()
                .setAmenityID(amenityID)
                .setName(name)
                .setDescription(description)
                .setAmenityAvailable(isAmenityAvailable)
                .setPrice(price)
                .build();
    }
}
