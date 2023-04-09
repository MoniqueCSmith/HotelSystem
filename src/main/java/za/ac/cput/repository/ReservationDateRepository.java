/*
ReservationDateRepository.java
ReservationDateRepository class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/

package za.ac.cput.repository;

import za.ac.cput.domain.ReservationDate;

import java.util.HashSet;
import java.util.Set;

public  class ReservationDateRepository implements IReservationDateRepository {

    private static ReservationDateRepository repository = null;
    private Set<ReservationDate> reservationDateDB = null;

    private ReservationDateRepository() {
        reservationDateDB = new HashSet<ReservationDate>();
    }

    public static ReservationDateRepository getRepository() {

        if (repository == null){
            repository = new ReservationDateRepository();
    }
   return repository;
}
    @Override
    public ReservationDate create(ReservationDate reservationDate) {
        boolean success = reservationDateDB.add(reservationDate);
        if(!success)
            return null;
            return reservationDate;
    }

    @Override
    public ReservationDate read(String reservationID) {

        ReservationDate reservationDate = reservationDateDB.stream()
                .filter(rd -> rd.getReservationID().equals(reservationID))
                .findAny()
                .orElse(null);
        return reservationDate;
    }


    @Override
    public ReservationDate update(ReservationDate reservationDate) {
        ReservationDate OldReservationDate= read(String.valueOf(reservationDate.getReservationID()));
        if (OldReservationDate != null){
          reservationDateDB.remove(OldReservationDate);
            reservationDateDB.add(reservationDate);
            return reservationDate;
        }
        return null ;
    }

    @Override
    public boolean delete(String reservationID) {
        ReservationDate reservationDate = read(reservationID);
        if(reservationDate==null)
            return false;
        reservationDateDB.remove(reservationDate);
        return true;
    }

    @Override
    public Set<ReservationDate> getAll() {
        return reservationDateDB;

    }
}
