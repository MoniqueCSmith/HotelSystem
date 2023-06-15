/* HotelLocationServiceImpl.java
 Service class for the HotelLocation class
 Author: Ashton Williams (220468478)
 Date: 10 June 2023
*/
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.HotelLocation;
import za.ac.cput.repository.impl.HotelLocationRepositoryImpl;
import za.ac.cput.service.HotelLocationService;

import java.util.Set;

@Service
public class HotelLocationServiceImpl implements HotelLocationService {

    private static HotelLocationServiceImpl service= null;
    private HotelLocationRepositoryImpl repository= null;

    private HotelLocationServiceImpl(){
        if(repository== null){
            repository= HotelLocationRepositoryImpl.getRepository();
        }
    }

    public static HotelLocationServiceImpl getService(){
        if(service==null){
            service= new HotelLocationServiceImpl();
        }
        return service;
    }

    @Override
    public HotelLocation create(HotelLocation hotelLocation) {
        return repository.create(hotelLocation);
    }

    @Override
    public HotelLocation read(String id) {
        return repository.read(id);
    }

    @Override
    public HotelLocation update(HotelLocation hotelLocation) {
        return repository.update(hotelLocation);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }

    @Override
    public Set<HotelLocation> getAll() {
        return repository.getAll();
    }
}
