
/*
ReservationDateControllerTest.java
ReservationDateControllerTest  class
Author : Kyra Petersen (219474559)
Date : 16 June 2023
*/

package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.ReservationDate;
import za.ac.cput.util.factory.ReservationDateFactory;


import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)

class ReservationDateControllerTest {
    private static ReservationDate reservationDate = ReservationDateFactory.buildReservationDate("REF978878171" , LocalDate.of(2024, 03 , 1),  LocalDate.of(2024,03,4),     LocalDateTime.of(2024, 03, 1, 15, 30));
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/reservationDate";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<ReservationDate> postResponse=restTemplate.postForEntity(url, reservationDate,ReservationDate.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ReservationDate savedReservationDate= postResponse.getBody();
        System.out.println("Saved data:" +savedReservationDate);
        assertEquals(reservationDate.getReservationID(),savedReservationDate.getReservationID() );
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + reservationDate.getReservationID();

        System.out.println("URL"+ url);
        ResponseEntity<ReservationDate>response= restTemplate.getForEntity(url, ReservationDate.class);
        assertEquals(reservationDate.getReservationID(), response.getBody().getReservationID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        ReservationDate updated = new ReservationDate .Builder().copy(reservationDate).setCheckInDate( LocalDate.of(2024, 03 , 02)).build();
        String url = baseURL + "/update";
        System.out.println("URL"+ url);
        System.out.println("Post data"+ updated);
        ResponseEntity<ReservationDate>response= restTemplate.postForEntity(url,updated, ReservationDate.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete"+ reservationDate.getReservationID();
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