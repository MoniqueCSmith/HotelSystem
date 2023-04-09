/* HotelLocationRepository.java
 Repository for Hotel Location class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/

package za.ac.cput.repository;

import za.ac.cput.domain.HotelLocation;

import java.util.HashSet;
import java.util.Set;

public class HotelLocationRepository implements IHotelLocationRepository {
    private final Set<HotelLocation> hotelLocationDB;
    private HotelLocationRepository() {
        hotelLocationDB = new HashSet<HotelLocation>();
    }

    private static HotelLocationRepository repository = null;

    public static HotelLocationRepository getRepository() {
        if (repository == null) {
            repository = new HotelLocationRepository();
        }
        return repository;
    }

    @Override
    public HotelLocation create(HotelLocation hotelLocation) {
        boolean pass = hotelLocationDB.add(hotelLocation);
        if(!pass)
            return null;
        return hotelLocation;
    }

    @Override
    public HotelLocation read(String hotelCode) {
        for (HotelLocation hotelLocation : hotelLocationDB) {
            if (hotelLocation.getHotelCode().equals(hotelCode)){
                return hotelLocation;
            }
        }
        return null;
    }

    @Override
    public HotelLocation update(HotelLocation hotelLocation) {
        HotelLocation oldHotelLocation = read(HotelLocation.getHotelCode());
        if(oldHotelLocation != null){
            hotelLocationDB.remove(oldHotelLocation);
            hotelLocationDB.add(hotelLocation);
            return hotelLocation;
        }
        return null;
    }

    @Override
    public boolean delete(String hotelCode) {
        HotelLocation hotelToDelete = read(hotelCode);
        if(hotelToDelete == null)
            return false;
        hotelLocationDB.remove(hotelToDelete);
        return true;
    }

    @Override
    public Set<HotelLocation> getAll() {
        return hotelLocationDB;
    }
}