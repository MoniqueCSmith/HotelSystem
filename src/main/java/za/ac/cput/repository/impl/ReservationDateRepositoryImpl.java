/*
ReservationDateRepository.java
ReservationDateRepository class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/

package za.ac.cput.repository.impl;

import za.ac.cput.domain.ReservationDate;
import za.ac.cput.repository.IReservationDateRepository;

import java.util.HashSet;
import java.util.Set;

public  class ReservationDateRepositoryImpl implements IReservationDateRepository {

    private static ReservationDateRepositoryImpl repository = null;
    private Set<ReservationDate> reservationDateDB = null;

    private ReservationDateRepositoryImpl() {
        reservationDateDB = new HashSet<ReservationDate>();
    }

    public static ReservationDateRepositoryImpl getRepository() {

        if (repository == null){
            repository = new ReservationDateRepositoryImpl();
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
        for (ReservationDate reservationDate : reservationDateDB) {
            if (reservationDate.getReservationID().equals(reservationID)) {
                return reservationDate;
            }
        }
        return null;
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
