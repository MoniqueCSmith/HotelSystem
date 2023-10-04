/*
ReservationFactory.java
Reservation factory POJO class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/

package za.ac.cput.factory;

import za.ac.cput.domain.Reservation;
import za.ac.cput.domain.ReservationDate;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class ReservationFactory {

    //Reservation objects
    public static Reservation buildReservation(LocalDateTime reservationTimeCreated, String reservationStatus , Boolean termsAndConditions, Boolean isChild,ReservationDate reservationDate ) {

        String reservationID=Helper.generateReservationID();


        if (
                Helper.isNullOrEmpty(String.valueOf(reservationTimeCreated)) ||
                Helper.isNullOrEmpty(String.valueOf(reservationStatus)) ||
                Helper.isNullOrEmpty(String.valueOf(termsAndConditions)) ||
                reservationDate == null) {
            return null;
        }

        return new Reservation.Builder()
                .setReservationID(reservationID)
                .setReservationTimeCreated(LocalDateTime.from(reservationTimeCreated))
                .setTermsAndConditions(termsAndConditions)
                .setIsChild(isChild)
                .setReservationStatus(reservationStatus)
                .setReservationDate(reservationDate)
                .build();


    }
}