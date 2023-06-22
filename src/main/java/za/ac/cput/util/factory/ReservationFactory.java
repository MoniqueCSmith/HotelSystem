/*
ReservationFactory.java
Reservation factory POJO class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/

package za.ac.cput.util.factory;

import za.ac.cput.domain.Reservation;
import za.ac.cput.domain.ReservationDate;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class ReservationFactory {

     //user objects
     public static Reservation buildReservation(String reservationID, LocalDateTime reservationTimeCreated, String reservationStatus , Boolean termsAndConditions, ReservationDate reservationDate) {


         /*if (reservationID.equals("") || reservationID == null)

             return null;

         if (reservationTimeCreated.equals("") || reservationTimeCreated == null)

             return null;

         if (reservationStatus.equals("") || reservationStatus == null)

             return null;*/
         String ReservationId=Helper.generateID();

             if (Helper.isNullOrEmpty(String.valueOf(reservationID))||
                     Helper.isNullOrEmpty(String.valueOf(reservationTimeCreated)) ||
                     Helper.isNullOrEmpty(String.valueOf(reservationStatus)) ||
                     Helper.isNullOrEmpty(String.valueOf(termsAndConditions)) ||
                     Helper.isNullOrEmpty(String.valueOf(reservationDate)))
                 return null;

             return new Reservation.Builder()
                     .setReservationID(reservationID)
                     .setReservationTimeCreated(LocalDateTime.from(reservationTimeCreated))
                     .setTermsAndConditions(termsAndConditions)
                     .setReservationStatus(reservationStatus)
                     .setReservationDate(reservationDate)
                     .build();


     }
 }