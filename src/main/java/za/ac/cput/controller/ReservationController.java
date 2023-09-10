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

public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;
    private ReservationDate reservationDate = new ReservationDate.Builder()
            .setCheckInDate(LocalDate.of(2023, 6, 15))
            .setCheckOutDate(LocalDate.of(2023, 6, 20))
            .setEstCheckInTime(LocalDateTime.of(2023, 6, 15, 14, 30))
            .build();



    @PostMapping("/crLocalDateTimeDate")
    public Reservation create (@RequestBody Reservation reservation){
        Reservation reservationCreated= ReservationFactory.buildReservation( reservation.getReservationTimeCreated(),reservation.getReservationStatus(),reservation.getTermsAndConditions(),reservation.getIsChild(),reservationDate );

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
    public List<Reservation> getAll(){
        return reservationService.getAll();

    }
}
