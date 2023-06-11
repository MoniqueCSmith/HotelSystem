

/*
ReservationDateServiceImpl.java
ReservationDateServiceImpl  class
Author : Kyra Petersen (219474559)
Date : 5 June 2023
*/
package za.ac.cput.service.impl;


import za.ac.cput.domain.ReservationDate;
import za.ac.cput.repository.ReservationDateRepository;
import za.ac.cput.service.ReservationDateService;


import java.util.Set;

public class ReservationDateServiceImpl implements ReservationDateService {
    private static ReservationDateService service = null;
    private static ReservationDateRepository repository=null;

    private ReservationDateServiceImpl() {
        if (repository == null) {
            repository = ReservationDateRepository.getRepository();

        }
    }
    public static ReservationDateService getService() {

        if (service == null){
            service = new ReservationDateServiceImpl();
        }
        return service;
    }
    @Override
    public ReservationDate create(ReservationDate reservationDate) {
         return repository.create(reservationDate);

    }

    @Override
    public ReservationDate read(ReservationDate reservationDate){

        return repository.read(reservationDate.getReservationID());
    }


    @Override
    public ReservationDate update(ReservationDate reservationDate) {
        return repository.update(reservationDate);
    }

    @Override
    public boolean delete(ReservationDate reservationID) {
        return repository.delete(reservationID.getReservationID());
    }

    public Set<ReservationDate> getAll() {
        return repository.getAll();

    }
}