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
import za.ac.cput.domain.*;

import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationControllerTest {


   /*private static ReservationDate reservationDate= ReservationDateFactory.buildReservationDate( LocalDate.of(2023, 9 , 1),  LocalDate.of(2023,9,4),     LocalTime.of( 15, 30));
    private static Guest guest = GuestFactory.createGuest();
    private static HotelLocation hotelLocation= HotelLocationFactory.createHotelLocation("51 Miltion Street Tygervalley", "Cape Town", "Western Cape", 7411, "0213109070");

    private static Review review = ReviewFactory.buildReview(5,"The best experience I've ever had!");
    Reservation reservation = ReservationFactory.buildReservation( LocalDateTime.now(), "Booking confirmed" , true, false, reservationDate, guest, hotelLocation, member,review);
    */

    //private static Member member = MemberFactory.buildMember("ffloppy@gmail.com", "carrot");

    ReservationInput reservationInput = new ReservationInput();
    public static Reservation savedReservation;

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/reservation";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Reservation> postResponse=restTemplate.postForEntity(url, reservationInput,Reservation.class);
        assertNotNull(postResponse);

        assertNotNull(postResponse.getBody());

        savedReservation = postResponse.getBody();

        System.out.println("Saved data:" + savedReservation);
        System.out.println("ReservationID:" + postResponse);
      //  assertEquals(reservation.getReservationID(),savedReservation.getReservationID() );
    }

   @Test
    void b_read() {
        String url = baseURL + "/read/"+ savedReservation.getReservationID();
        System.out.println("URL"+ url);
        ResponseEntity<Reservation>response= restTemplate.getForEntity(url, Reservation.class);
        assertEquals(savedReservation.getReservationID(), response.getBody().getReservationID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Reservation updated = new Reservation .Builder().copy(savedReservation).setIsChild(true).build();
        String url = baseURL + "/update";
        System.out.println("URL"+ url);
        System.out.println("Post data"+ updated);
        ResponseEntity<Reservation>response= restTemplate.postForEntity(url,updated, Reservation.class);
        assertNotNull(response.getBody());


    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete"+ savedReservation.getReservationID();
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
