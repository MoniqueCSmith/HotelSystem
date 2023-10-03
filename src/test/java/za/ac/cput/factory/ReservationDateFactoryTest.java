/*
ReservationDateFactoryTest.java
ReservationDateFactory Test class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ReservationDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReservationDateFactoryTest {


    @Test
    public void createReservationDate() {
        ReservationDate reservationDate = ReservationDateFactory.buildReservationDate( LocalDate.of(2023, 9 , 1),  LocalDate.of(2023,9,4),     LocalTime.of( 15, 30));
        assertNotNull(reservationDate);
        System.out.println(reservationDate);

    }

}