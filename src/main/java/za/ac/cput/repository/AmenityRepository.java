/**
 * AmenityRepository.java
 * Repository class for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Amenity;

import java.util.HashSet;
import java.util.Set;

public class AmenityRepository implements IAmenityRepository {
    private static AmenityRepository repository = null;
    private Set<Amenity> amenityDB = null;

    private AmenityRepository(){
        amenityDB = new HashSet<Amenity>();
    }
    public static AmenityRepository getRepository(){
        if(repository == null) {
            repository = new AmenityRepository();
        }
        return repository;

    }
    @Override
    public Amenity create(Amenity amenity) {
        boolean success = amenityDB.add(amenity);
        if(!success)
            return null;
        return amenity;

    }

    @Override
    public Amenity read(String amenityID) {
        for (Amenity a : amenityDB) {
            if (a.getAmenityID().equals(amenityID))
                return a;
        }
        return null;

    }

    @Override
    public Amenity update(Amenity amenity) {
        Amenity oldAmenity = read(amenity.getAmenityID());
        if(oldAmenity != null){
            amenityDB.remove(oldAmenity);
            amenityDB.add(amenity);
            return amenity;
        }
        return null;
    }

    @Override
    public boolean delete(String amenityID) {
        Amenity amenityToDelete = read(amenityID);
        if(amenityToDelete == null)
            return false;
        amenityDB.remove(amenityToDelete);
        return true;
    }
    @Override
    public Set<Amenity> getAll() {
        return amenityDB;
    }
}
