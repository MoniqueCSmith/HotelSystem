/* HotelLocationController.java
 Controller for the Hotel Location class
 Author: Ashton Williams (220468478)
 Date: 15 June 2023
*/
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.HotelLocation;
import za.ac.cput.util.factory.HotelLocationFactory;
import za.ac.cput.service.HotelLocationService;

import java.util.Set;

@RestController
@RequestMapping("/hotellocation")
public class HotelLocationController {

    @Autowired
    private HotelLocationService hotelLocationService;

    @PostMapping("/create")
    public HotelLocation create(@RequestBody HotelLocation hotelLocation){
       HotelLocation HotelLocationCreated = HotelLocationFactory.createHotelLocation(hotelLocation.getAddress(), hotelLocation.getCity(),
                hotelLocation.getProvince(), hotelLocation.getZipCode());
        return hotelLocationService.create(HotelLocationCreated);
    }

    @GetMapping("/read/{id}")
    public HotelLocation read(@PathVariable String id){
        return hotelLocationService.read(id);
    }

    @PostMapping("/update")
    public HotelLocation update(@RequestBody HotelLocation hotelLocation){
        return hotelLocationService.update(hotelLocation);
    }

    @DeleteMapping("/delete")
    public boolean delete(@PathVariable String id){
        return hotelLocationService.delete(id);
    }

    @GetMapping("/getall")
    public Set<HotelLocation> getall(){
        return hotelLocationService.getAll();
    }
}
