/* IHotelLocationRepository.java
 Interface for the Hotel Location Repository class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.HotelLocation;
import java.util.Set;

public interface IHotelLocationRepository extends IRepository<HotelLocation, String> {
    public Set<HotelLocation> getAll();
}


