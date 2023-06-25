/* IHotelLocationRepository.java
 Interface for the Hotel Location Repository class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.HotelLocation;

@Repository
public interface IHotelLocationRepository extends JpaRepository<HotelLocation, String> {
}
