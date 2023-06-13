/**
 * AmenityController.java
 * Controller class for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 13 June 2023
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Amenity;
import za.ac.cput.service.impl.AmenityServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/amenity")
public class AmenityController {

    @Autowired
    private AmenityServiceImpl amenityService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Amenity create(@RequestBody Amenity amenity){

        return amenityService.create(amenity);
    }
    @GetMapping("/read/{id}")
    public Amenity read(@PathVariable String id){
        return amenityService.read(id);
    }

    @PostMapping("/update")
    public Amenity update(@RequestBody Amenity amenity){
        return amenityService.update(amenity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return amenityService.delete(id);
    }

    @RequestMapping("/getall")
    public Set<Amenity> getall(){
        return amenityService.getAll();
    }



}