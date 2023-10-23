
/*
ReservationServiceImpl.java
ReservationServiceImpl  class
Author : Kyra Petersen (219474559)
Date : 5 June 2023
*/


package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Reservation;
import za.ac.cput.repository.IReservationRepository;
import za.ac.cput.service.ReservationService;

import java.util.List;
import java.util.Set;
@Service
public class ReservationServiceImpl implements ReservationService {

  private IReservationRepository repository;
@Autowired
    private ReservationServiceImpl(IReservationRepository repository) {
    this.repository= repository;
    }

    @Override
    public Reservation create(Reservation reservation) {
        return repository.save(reservation);

    }

    @Override
    public Reservation read(String reservationID){
        return this.repository.findById(reservationID).orElse(null);
    }



    @Override
    public Reservation update(Reservation reservation) {
        if (this.repository.existsById(reservation.getReservationID()))
            return repository.save(reservation);
        return null;
    }

    @Override
    public boolean delete(String reservationID){
            if (this.repository.existsById(reservationID)) {
                this.repository.deleteById(reservationID);
                return true;
            }
            return false;
        }
    @Override
    public List<Reservation> getAll() {
        return this.repository.findAll();

    }
}
