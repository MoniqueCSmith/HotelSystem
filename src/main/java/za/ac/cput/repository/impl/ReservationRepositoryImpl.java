/*
ReservationRepositoryTest.java
Reservation Repository test class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/


package za.ac.cput.repository.impl;

import za.ac.cput.domain.Reservation;
import za.ac.cput.repository.IReservationRepository;

import java.util.HashSet;
import java.util.Set;

public  class ReservationRepositoryImpl implements IReservationRepository {

    private static ReservationRepositoryImpl repository = null;
    private Set<Reservation> reservationDB = null;

    private ReservationRepositoryImpl() {
        reservationDB = new HashSet<Reservation>();
    }

    public static ReservationRepositoryImpl getRepository() {

        if (repository == null){
            repository = new ReservationRepositoryImpl();
        }
        return repository;
    }
    @Override
    public Reservation create(Reservation reservation) {
        boolean success = reservationDB.add(reservation);
        if(!success)
            return null;
        return reservation;
    }
//made changes
@Override
public Reservation read(String reservationID) {
    for (Reservation reservation : reservationDB) {
        if (reservation.getReservationID().equals(reservationID)) {
            return reservation;
        }
    }
    return null;
}



    @Override
    public Reservation update(Reservation reservation) {
        Reservation oldReservation= read(reservation.getReservationID());
        if (oldReservation != null){
            reservationDB.remove(oldReservation);
            reservationDB.add(reservation);
            return reservation;
        }
        return null ;
    }

    @Override
    public boolean delete(String reservationID) {
        Reservation reservationToDelete = read(reservationID);
        if(reservationToDelete==null)
            return false;
        reservationDB.remove(reservationToDelete);
        return true;
    }

    public Set<Reservation> getAll() {
        return reservationDB;
    }

}