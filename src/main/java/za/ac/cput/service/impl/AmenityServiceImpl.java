/**
 * AmenityServiceImpl.java
 * Service class for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Amenity;
import za.ac.cput.repository.IAmenityRepository;
import za.ac.cput.service.AmenityService;


import java.util.List;
import java.util.Set;
@Service
public class AmenityServiceImpl implements AmenityService {


    private IAmenityRepository repository;

    @Autowired
    private AmenityServiceImpl(IAmenityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Amenity create(Amenity amenity) {
        return this.repository.save(amenity);
    }

    @Override
    public Amenity read(String amenityId) {
        return this.repository.findById(amenityId).orElse(null);
    }

    @Override
    public Amenity update(Amenity amenity) {
        if(this.repository.existsById(amenity.getAmenityID())) {
            return this.repository.save(amenity);
        }
        return null;
    }

    @Override
    public boolean delete(String amenityId) {
        if(this.repository.existsById(amenityId)) {
            this.repository.deleteById(amenityId);
            return true;
        }
        return false;

    }

    @Override
    public List<Amenity> getAll() {
        return this.repository.findAll();
    }
}