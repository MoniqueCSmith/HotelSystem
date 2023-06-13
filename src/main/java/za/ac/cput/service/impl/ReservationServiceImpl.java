
/*
ReservationServiceImpl.java
ReservationServiceImpl  class
Author : Kyra Petersen (219474559)
Date : 5 June 2023
*/


package za.ac.cput.service.impl;

import za.ac.cput.domain.Reservation;
import za.ac.cput.repository.ReservationRepository;
import za.ac.cput.service.ReservationService;

import java.util.Set;

public class ReservationServiceImpl implements ReservationService {

    private static ReservationService service = null;
    private  ReservationRepository repository=null;

    private ReservationServiceImpl() {
        if (repository == null) {
            repository = ReservationRepository.getRepository();

        }
    }
    public static ReservationService getService() {

        if (service == null){
            service = new ReservationServiceImpl();
        }
        return service;
    }
    @Override
    public Reservation create(Reservation reservation) {
        return repository.create(reservation);

    }

    @Override
    public Reservation read(String reservationID){
        return repository.read(reservationID);
    }



    @Override
    public Reservation update(Reservation reservation) {
        return repository.update(reservation);
    }

    @Override
    public boolean delete(String reservationID) {
        return repository.delete(reservationID);
    }

    public Set<Reservation> getAll() {
        return repository.getAll();

    }
}