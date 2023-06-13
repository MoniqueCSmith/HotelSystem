
/*
ReservationServiceImplTest.java
ReservationServiceImplTest  class
Author : Kyra Petersen (219474559)
Date : 6  June 2023
*/

package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Reservation;
import za.ac.cput.domain.ReservationDate;
import za.ac.cput.factory.ReservationFactory;
import za.ac.cput.service.ReservationService;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ReservationServiceImplTest {
    private ReservationService service;
    private Reservation reservation;

    @BeforeEach
    void setup() {
        service = ReservationServiceImpl.getService();
        reservation = ReservationFactory.buildReservation("REF6162722732",
                LocalDateTime.now(),
                "Waiting List",
                false ,
                new ReservationDate());
    }
    @Test
    void a_create() {
        Reservation created = service.create(reservation);
        assertEquals(reservation.getReservationID(),created.getReservationID());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {
        Reservation read = service.read(reservation.getReservationID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Reservation updated = new Reservation.Builder()
                .copy(reservation)
                .setReservationID(reservation.getReservationID())
                .setReservationTimeCreated( LocalDateTime.now())
                .setReservationStatus("Booked")
                .setTermsAndConditions(true)
                .build();

        assertNotNull(updated);
        System.out.println("Updated"+ updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(reservation.getReservationID());
        assertTrue(success);
        System.out.println("Deleted " + success);

    }

    @Test
    void d_getAll() {
        System.out.println("Show all ");
        System.out.println(service.getAll());
    }
}