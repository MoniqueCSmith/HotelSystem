/*
ReservationController.java
ReservationController  class
Author : Kyra Petersen (219474559)
Date : 15 June 2023
*/



package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.impl.GuestServiceImpl;
import za.ac.cput.service.impl.ReservationServiceImpl;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservation")

public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;
    @Autowired
    private GuestServiceImpl guestService;

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/create")
    public Reservation create (@RequestBody ReservationInput reservationInput){
        System.out.println("Received ReservationInput: " + reservationInput);

        /*
        Front end data example
        {checkInDate: '2023-10-05', checkOutDate: '2023-10-25', estCheckInTime: '18:31', hasChild: false, acceptTerms: true}

        */

        ReservationDate reservationDate= ReservationDateFactory.buildReservationDate( reservationInput.getCheckInDate(),  reservationInput.getCheckOutDate(), reservationInput.getEstCheckInTime());
        HotelLocation hotelLocation= HotelLocationFactory.createHotelLocation("51 Miltion Street Tygervalley", "Cape Town", "Western Cape", 7411, "0213109070");
        Review review = ReviewFactory.buildReview(4,"The best experience I've ever had!");
        // create guest object
        Guest guest = GuestFactory.createGuest("Damon", "Salvatore", "1420 Walnut Drive", "0846254695", "damonsalvatore@gmail.com");
        // putting the guest object in db
        guestService.create(guest);


        Reservation reservationCreated = ReservationFactory.buildReservation( LocalDateTime.now(), "Confirmed",reservationInput.getTermsAndConditions(),reservationInput.getChild(),reservationDate, guest, hotelLocation/*, member*/,review );


         return reservationService.create(reservationCreated);
    }

    @GetMapping("/read/{id}")
    public Reservation read(@PathVariable String id){
        return reservationService.read(id);
    }

    @PostMapping("/update")
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return reservationService.delete(id);
    }

    @RequestMapping({"/getall"})
    public List<Reservation> getAll(){
        return reservationService.getAll();

    }
}

