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
import za.ac.cput.domain.Guest;
import za.ac.cput.factory.GuestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GuestControllerTest {



    @Autowired
    private TestRestTemplate restTemplate;

    private static Guest guest = GuestFactory.createGuest("Bonnie", "Bennett", "2136 Conyers Street", "0724123265", "bonniebennett@gmail.com");
    private final String baseURL = "http://localhost:8080/guest";

    @Test
    void a_create() {
        System.out.println(guest);
        String url = baseURL + "/create";
        ResponseEntity<Guest> postResponse = restTemplate.postForEntity(url, guest, Guest.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Guest savedGuest = postResponse.getBody();
        System.out.println("Saved data: " + savedGuest);
        assertEquals(guest.getGuestID(), savedGuest.getGuestID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + guest.getGuestID();
        System.out.println("URL: " + url);
        ResponseEntity<Guest> response = restTemplate.getForEntity(url, Guest.class);
        assertEquals(guest.getGuestID(), response.getBody().getGuestID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Guest updated = new Guest.Builder().copy(guest).build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Guest> response = restTemplate.postForEntity(url, updated, Guest.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + guest.getGuestID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}