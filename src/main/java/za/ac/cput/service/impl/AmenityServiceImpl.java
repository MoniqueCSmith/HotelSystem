/**
 * AmenityServiceImpl.java
 * Service class for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import za.ac.cput.domain.Amenity;
import za.ac.cput.repository.AmenityRepository;
import za.ac.cput.service.AmenityService;


import java.util.Set;

public class AmenityServiceImpl implements AmenityService {

    private static AmenityServiceImpl service = null;
    private AmenityRepository repository = null;

    private AmenityServiceImpl(){
        if(repository ==null){
            repository = AmenityRepository.getRepository();
        }
    }

    public static AmenityServiceImpl getService(){
        if(service == null){
            service = new AmenityServiceImpl();
        }
        return service;
    }

    @Override
    public Amenity create(Amenity amenity){return repository.create(amenity);}

    @Override
    public Amenity read(Amenity id){return repository.read(id.getAmenityID());}

    @Override
    public Amenity update(Amenity amenity) {
        return repository.update(amenity);
    }

    @Override
    public boolean delete(Amenity id) {
        return repository.delete(id.getAmenityID());
    }
    @Override
    public Set<Amenity> getAll() {
        return repository.getAll();
    }

}
