package za.ac.cput.service.impl;

/*
ReservationDateServiceImpl.java
ReservationDateServiceImpl  class
Author : Kyra Petersen (219474559)
Date : 5 June 2023
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ReservationDate;
import za.ac.cput.service.ReservationDateService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.factory.ReservationDateFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ReservationDateServiceImplTest {

    private ReservationDateService service;
    private ReservationDate reservationDate;

    @BeforeEach
    void setup() {
        service = ReservationDateServiceImpl.getService();
        reservationDate = ReservationDateFactory.buildReservationDate(
                "REF8272927262",
                LocalDate.of(2023, 6, 15),
                LocalDate.of(2023, 6, 18),
                LocalDateTime.of(2023, 6, 7, 16, 30));
    }

    @Test
    void a_create() {
        setup();
        ReservationDate created = service.create(reservationDate);
        assertEquals(reservationDate.getReservationID(), created.getReservationID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        ReservationDate read = service.read(reservationDate);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        ReservationDate updated = new ReservationDate.Builder()
                .setReservationID(reservationDate.getReservationID())
                .setCheckInDate(LocalDate.of(2023, 6, 8))
                .setCheckOutDate(LocalDate.of(2023, 6, 11))
                .setEstCheckInTime(LocalDateTime.of(2023, 6, 7, 13, 0))
                .build();
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }


    @Test
    void e_delete() {
        boolean success = service.delete(reservationDate);
        assertTrue(success);
        System.out.println("Deleted " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all ");
        System.out.println(service.getAll());
    }
}