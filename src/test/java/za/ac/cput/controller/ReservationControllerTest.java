/*
ReservationControllerTest.java
ReservationControllerTest  class
Author : Kyra Petersen (219474559)
Date : 16 June 2023
*/

package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Reservation;

import za.ac.cput.domain.ReservationDate;
import za.ac.cput.factory.ReservationDateFactory;
import za.ac.cput.factory.ReservationFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;



@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationControllerTest {
    //last parameter check again

    private static ReservationDate reservationDate= ReservationDateFactory.buildReservationDate(LocalDate.of(2024, 03 , 1),  LocalDate.of(2023,03,4),     LocalDateTime.of(2024, 03, 1, 15, 30));
    private static Reservation reservation = ReservationFactory.buildReservation( LocalDateTime.now(), "Waiting List", true, false, reservationDate);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/reservation";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Reservation> postResponse=restTemplate.postForEntity(url, reservation,Reservation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Reservation savedReservation= postResponse.getBody();
        System.out.println("Saved data:" +savedReservation);
        assertEquals(reservation.getReservationID(),savedReservation.getReservationID() );
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/"+ reservation.getReservationID();
        System.out.println("URL"+ url);
        ResponseEntity<Reservation>response= restTemplate.getForEntity(url, Reservation.class);
        assertEquals(reservation.getReservationID(), response.getBody().getReservationID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Reservation updated = new Reservation .Builder().copy(reservation).setReservationStatus("Confirmed").build();
        String url = baseURL + "/update";
        System.out.println("URL"+ url);
        System.out.println("Post data"+ updated);
        ResponseEntity<Reservation>response= restTemplate.postForEntity(url,updated, Reservation.class);
        assertNotNull(response.getBody());


    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete"+ reservation.getReservationID();
        System.out.println("URL"+ url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url , HttpMethod.GET, entity, String.class);
        System.out.println("Show All");
        System.out.println(response.getBody());



    }
}