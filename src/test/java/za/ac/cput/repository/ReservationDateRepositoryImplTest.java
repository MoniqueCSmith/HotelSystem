/* 
ReservationDateRepositoryTest.java 
ReservationDateRepositoryTest class 
Author : Kyra Petersen (219474559) 
Date : 5 April 2023 
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ReservationDate;
import za.ac.cput.factory.ReservationDateFactory;
import za.ac.cput.repository.impl.ReservationDateRepositoryImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
class ReservationDateRepositoryImplTest {
    private static ReservationDateRepositoryImpl repository = ReservationDateRepositoryImpl.getRepository();
    private static ReservationDate reservationDate = ReservationDateFactory.buildReservationDate(
            "REF8272927262",
            LocalDate.of(2023, 6, 15),
            LocalDate.of(2023, 6, 18),
            LocalDateTime.of(2023, 6, 7, 16, 30)
    );
    @Test
    void a_create() {
        ReservationDate created = repository.create(reservationDate);
        assertEquals(reservationDate.getReservationID(),created.getReservationID());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {
        ReservationDate read = repository.read(reservationDate.getReservationID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        ReservationDate updated = new ReservationDate.Builder()
                .copy(reservationDate)
                .setReservationID(reservationDate.getReservationID())
                .setCheckInDate(LocalDate.of(2023, 6, 7))
                .setCheckOutDate(LocalDate.of(2023, 6, 10))
                .setEstCheckInTime(LocalDateTime.of(2023, 6, 7, 14, 0))
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated"+ updated);
    }
    @Test
    void e_delete() {
        boolean success = repository.delete(reservationDate.getReservationID());
        assertTrue(success);
        System.out.println("Deleted " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all ");
        System.out.println(repository.getAll());
    }
} 

 