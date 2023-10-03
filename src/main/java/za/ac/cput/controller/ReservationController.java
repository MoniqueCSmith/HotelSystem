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
import za.ac.cput.domain.ReservationDate;
import za.ac.cput.factory.ReservationFactory;

import za.ac.cput.service.impl.ReservationServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservation")
//@CrossOrigin("http://localhost:8080")
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping("/create")
    public Reservation create (@RequestBody Reservation reservation){
        Reservation reservationCreated= ReservationFactory.buildReservation( reservation.getReservationTimeCreated(),reservation.getReservationStatus(),reservation.getTermsAndConditions(),reservation.getIsChild(),reservation.getReservationDate() );

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
