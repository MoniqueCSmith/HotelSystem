/*
ReservationDateFactory.java
ReservationDate factory class
Author : Kyra Petersen (219474559)
Date : 5 June 2023
*/


package za.ac.cput.util.factory;

import za.ac.cput.domain.ReservationDate;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationDateFactory {


    public static ReservationDate buildReservationDate(String reservationID , LocalDate checkInDate , LocalDate checkOutDate , LocalDateTime estCheckInTime ){
        String reservationId = Helper.generateID();

        if (Helper.isNullOrEmpty(String.valueOf(reservationID))||
                Helper.isNullOrEmpty(String.valueOf(checkInDate)) ||
                Helper.isNullOrEmpty(String.valueOf(checkOutDate)) ||
                Helper.isNullOrEmpty(String.valueOf(estCheckInTime))) return null;

        return new ReservationDate.Builder()
                .setReservationID(reservationID)
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .setEstCheckInTime(estCheckInTime)
                .build();
    }
}
