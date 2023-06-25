/* HotelLocationServiceImpl.java
 Service class for the HotelLocation class
 Author: Ashton Williams (220468478)
 Date: 10 June 2023
*/
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.HotelLocation;
import za.ac.cput.repository.IHotelLocationRepository;
import za.ac.cput.service.HotelLocationService;

import java.util.List;

@Service
public class HotelLocationServiceImpl implements HotelLocationService {

    private IHotelLocationRepository repository;

    @Autowired
    private HotelLocationServiceImpl(IHotelLocationRepository repository){
        this.repository= repository;
    }

    @Override
    public HotelLocation create(HotelLocation hotelLocation) {
        return this.repository.save(hotelLocation);
    }

    @Override
    public HotelLocation read(String ID) {
        return this.repository.findById(ID).orElse(null);
    }

    @Override
    public HotelLocation update(HotelLocation hotelLocation) {
        if(this.repository.existsById(hotelLocation.getID())){
            return this.repository.save(hotelLocation);
        }
        return null;
    }

    @Override
    public boolean delete(String ID) {
        if(this.repository.existsById(ID)){
            this.repository.deleteById(ID);
            return true;
        }
        return false;
    }

    @Override
    public List<HotelLocation> getAll() {
        return this.repository.findAll();
    }
}
