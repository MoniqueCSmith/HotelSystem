/*
ReservationFactoryTest.java
ReservationFactory Test class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReservationFactoryTest {
    @Test

    public void createReservation(){
        ReservationDate reservationDate = ReservationDateFactory.buildReservationDate(LocalDate.of(2023, 9 , 1),  LocalDate.of(2023,9,4),     LocalTime.of(15, 30));
        Guest guest = GuestFactory.createGuest();
        //Member member = MemberFactory.buildMember("ffloppy@gmail.com", "carrot");
        Review review = ReviewFactory.buildReview(4, "This was a very pleasant stay. Would recommend");
        HotelLocation hotelLocation= HotelLocationFactory.createHotelLocation("32 Burger Street Camps Bay", "Cape Town", "Western Cape", 7301, "0215900310");
        Reservation reservation = ReservationFactory.buildReservation( LocalDateTime.now(), "Booking confirmed" , true, false, reservationDate,guest, hotelLocation/*,member*/, review);
        assertNotNull(reservation);
        System.out.println(reservation);
    }
}
