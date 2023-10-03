/*
ReservationDateFactory.java
ReservationDate factory class
Author : Kyra Petersen (219474559)
Date : 5 June 2023
*/


package za.ac.cput.factory;

import za.ac.cput.domain.ReservationDate;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;

import static za.ac.cput.util.Helper.isCheckInTimeValid;

public class ReservationDateFactory {


    public static ReservationDate buildReservationDate( LocalDate checkInDate , LocalDate checkOutDate , LocalTime estCheckInTime ){


        if (
                Helper.isNullOrEmpty(String.valueOf(checkInDate)) ||
                Helper.isNullOrEmpty(String.valueOf(checkOutDate)) ||
                Helper.isNullOrEmpty(String.valueOf(estCheckInTime))) {return null;}

        if (!Helper.isDateRangeValid(checkInDate, checkOutDate)) {
            return null;
        }

        if (!isCheckInTimeValid(estCheckInTime)) {
            return null;
        }
        return new ReservationDate.Builder()
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .setEstCheckInTime(estCheckInTime)
                .build();
    }
}
