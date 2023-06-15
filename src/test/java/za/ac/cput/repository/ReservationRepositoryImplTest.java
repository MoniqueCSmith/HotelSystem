/* 
ReservationRepositoryTest.java 
ReservationRepositoryTest class 
Author : Kyra Petersen (219474559) 
Date : 5 April 2023 
*/

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Reservation;
import za.ac.cput.domain.ReservationDate;
import za.ac.cput.factory.ReservationFactory;
import za.ac.cput.repository.impl.ReservationRepositoryImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ReservationRepositoryImplTest {
    private static ReservationRepositoryImpl repository = ReservationRepositoryImpl.getRepository();
    private static Reservation reservation = ReservationFactory.buildReservation("REF6162722732", LocalDateTime.now(), "Waiting List",false , new ReservationDate());

    @Test
    void a_create() {
        Reservation created = repository.create(reservation);
        assertEquals(reservation.getReservationID(),created.getReservationID());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {
        Reservation read = repository.read(reservation.getReservationID());
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

        assertNotNull(repository.update(updated));
        System.out.println("Updated"+ updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(reservation.getReservationID());
        assertTrue(success);
        System.out.println("Deleted " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all ");
        System.out.println(repository.getAll());
    }
} 

 