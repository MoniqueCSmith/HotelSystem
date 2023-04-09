/*
ReservationDateFactory.java
ReservationDate factory class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/


package za.ac.cput.factory;

import za.ac.cput.domain.ReservationDate;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationDateFactory {


    public static ReservationDate createReservationDate(String reservationID , LocalDate checkInDate , LocalDate checkOutDate , LocalDateTime estCheckInTime ){
        if (Helper.isNullorEmpty(String.valueOf(reservationID))||
                Helper.isNullorEmpty(String.valueOf(checkInDate)) ||
                Helper.isNullorEmpty(String.valueOf(checkOutDate)) ||
                Helper.isNullorEmpty(String.valueOf(estCheckInTime))) return null;


        return new ReservationDate.Builder()
                .setReservationID(reservationID)
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .setEstCheckInTime(estCheckInTime)
                .build();
    }
}
