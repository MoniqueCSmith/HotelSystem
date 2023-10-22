package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ReservationServiceImplTest {
    @Autowired
    private ReservationServiceImpl service;
    private static HotelLocation hotelLocation= HotelLocationFactory.createHotelLocation("6 Nassau Street Milnerton", "Cape Town", "Western Cape",7441,"0213907901");

    private static ReservationDate reservationDate= ReservationDateFactory.buildReservationDate(LocalDate.of(2024, 3 , 1),  LocalDate.of(2024,3,4), LocalTime.of(15, 30));

  private static Guest guest = GuestFactory.createGuest("Damon", "Salvatore", "1420 Walnut Drive", "0846254695", "damonsalvatore@gmail.com");

  //private static Member member = MemberFactory.buildMember("ffloppy@gmail.com", "carrot");

    private static Review review = ReviewFactory.buildReview(5, "such an amazing experience.");

    private static Reservation reservation= ReservationFactory.buildReservation( LocalDateTime.now(), "Waiting List" , true, true, reservationDate, guest, hotelLocation/*, member*/, review);
    @Test
    void a_create() {
        Reservation created= service.create(reservation);
        System.out.println("Guest"+ guest.getGuestID());
        assertEquals(reservation.getReservationID(),created.getReservationID());
        System.out.println("Created"+ created);
    }

   @Test
    void b_read() {
        Reservation read= service.read(reservation.getReservationID());

       System.out.println("Guest"+ guest.getGuestID());
        assertNotNull(read);
        System.out.println("Read"+ read);
    }

    @Test
    void c_update() {
        Reservation newReservation= new Reservation.Builder().copy(reservation).setTermsAndConditions(true).build();
        Reservation updated= service.update(newReservation);
        assertEquals(reservation.getTermsAndConditions(), updated.getTermsAndConditions());
        System.out.println("updated"+ updated);
    }
    @Disabled
    @Test
    void e_delete() {
        boolean success = service.delete(reservation.getReservationID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All: ");
        System.out.println(service.getAll());

    }

}
