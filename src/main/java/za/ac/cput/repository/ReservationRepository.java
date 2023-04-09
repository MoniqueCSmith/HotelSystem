/*
ReservationRepositoryTest.java
Reservation Repository test class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/


package za.ac.cput.repository;

import za.ac.cput.domain.Reservation;

import java.util.HashSet;
import java.util.Set;

public  class ReservationRepository implements IReservationRepository {

    private static ReservationRepository repository = null;
    private Set<Reservation> reservationDB = null;

    private ReservationRepository() {
        reservationDB = new HashSet<Reservation>();
    }

    public static ReservationRepository getRepository() {

        if (repository == null){
            repository = new ReservationRepository();
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

    @Override
    public Reservation read(String reservationID){

        Reservation reservation = reservationDB.stream()
                .filter(rd -> rd.getReservationID().equals(reservationID))
                .findAny()
                .orElse(null);
        return reservation;
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