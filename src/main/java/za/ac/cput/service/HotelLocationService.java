/* HotelLocationService.java
 Service interface for the HotelLocationServiceImpl class
 Author: Ashton Williams (220468478)
 Date: 10 June 2023
*/
package za.ac.cput.service;

import za.ac.cput.domain.HotelLocation;

import java.util.Set;

public interface HotelLocationService extends IService<HotelLocation, String>{

    Set<HotelLocation> getAll();
}
