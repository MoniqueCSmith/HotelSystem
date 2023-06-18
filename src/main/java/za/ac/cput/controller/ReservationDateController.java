/*
ReservationDateController.java
ReservationDateController  class
Author : Kyra Petersen (219474559)
Date : 15 June 2023
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ReservationDate;
import za.ac.cput.factory.ReservationDateFactory;
import za.ac.cput.service.impl.ReservationDateServiceImpl;
import java.util.Set;


@RestController
@RequestMapping("/reservationDate")
public class ReservationDateController { @Autowired
private ReservationDateServiceImpl reservationDateService;

    @PostMapping("/create")
    public ReservationDate create (@RequestBody ReservationDate reservationDate){
        ReservationDate reservationDateCreated= ReservationDateFactory.buildReservationDate(reservationDate.getReservationID(), reservationDate.getCheckInDate(),reservationDate.getCheckOutDate(),reservationDate.getEstCheckInTime());

        return reservationDateService.create(reservationDateCreated);
    }

    @GetMapping("/read/{ID}")
    public ReservationDate read(@PathVariable String ID){
        return reservationDateService.read(ID);
    }

    @PostMapping("/update")
    public ReservationDate update(@RequestBody ReservationDate reservationDate) {
        return reservationDateService.update(reservationDate);
    }

    @DeleteMapping("delete/{ID}")
    public boolean delete(@PathVariable String ID){
        return reservationDateService.delete(ID);
    }

    @RequestMapping({"/getall"})
    public Set<ReservationDate> getAll(){
        return reservationDateService.getAll();

    }
}

