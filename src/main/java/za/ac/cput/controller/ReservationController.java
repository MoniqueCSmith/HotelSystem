/*
ReservationController.java
ReservationController  class
Author : Kyra Petersen (219474559)
Date : 15 June 2023
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.Reservation;
import za.ac.cput.util.factory.ReservationFactory;

import za.ac.cput.service.impl.ReservationServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/reservation")

public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping("/create")
    public Reservation create (@RequestBody Reservation reservation){
        Reservation reservationCreated= ReservationFactory.buildReservation(reservation.getReservationID(), reservation.getReservationTimeCreated(),reservation.getReservationStatus(),reservation.getTermsAndConditions(),reservation.getReservationDate());

        return reservationService.create(reservationCreated);
    }

    @GetMapping("/read/{ID}")
    public Reservation read(@PathVariable String ID){
        return reservationService.read(ID);
    }

    @PostMapping("/update")
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("delete/{ID}")
    public boolean delete(@PathVariable String ID){
        return reservationService.delete(ID);
    }

    @RequestMapping({"/getall"})
    public Set<Reservation> getAll(){
        return reservationService.getAll();

    }
}
