package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Amenity;
import za.ac.cput.factory.AmenityFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AmenityControllerTest {
    private static Amenity amenity1 = AmenityFactory.buildAmenity("Shampoo", "Toiletries", true, 25.00);
    private static Amenity amenity2 = AmenityFactory.buildAmenity("Condtioner", "Toiletries", true, 25.00);
    private static Amenity amenity3 = AmenityFactory.buildAmenity("Lotion", "Toiletries", true, 30.00);
    private static Amenity amenity4 = AmenityFactory.buildAmenity("Toothpaste", "Toiletries", true, 20.00);
    private static Amenity amenity5 = AmenityFactory.buildAmenity("Blow-dryer", "Electronics", true, 20.00);
    private static Amenity amenity6 = AmenityFactory.buildAmenity("Flat Iron", "Electronics", true, 20.00);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/amenity";

    @Test
    void a_create1() {
        String url = baseURL + "/create";
        ResponseEntity<Amenity> postResponse = restTemplate.postForEntity(url, amenity1, Amenity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Amenity savedAmenity = postResponse.getBody();
        System.out.println("Saved data:" + savedAmenity);
        assertEquals(amenity1.getAmenityID(), savedAmenity.getAmenityID());

    }
    @Test
    void a_create2() {
        String url = baseURL + "/create";
        ResponseEntity<Amenity> postResponse = restTemplate.postForEntity(url, amenity2, Amenity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Amenity savedAmenity = postResponse.getBody();
        System.out.println("Saved data:" + savedAmenity);
        assertEquals(amenity2.getAmenityID(), savedAmenity.getAmenityID());

    }
    @Test
    void a_create3() {
        String url = baseURL + "/create";
        ResponseEntity<Amenity> postResponse = restTemplate.postForEntity(url, amenity3, Amenity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Amenity savedAmenity = postResponse.getBody();
        System.out.println("Saved data:" + savedAmenity);
        assertEquals(amenity3.getAmenityID(), savedAmenity.getAmenityID());

    }
    @Test
    void a_create4() {
        String url = baseURL + "/create";
        ResponseEntity<Amenity> postResponse = restTemplate.postForEntity(url, amenity4, Amenity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Amenity savedAmenity = postResponse.getBody();
        System.out.println("Saved data:" + savedAmenity);
        assertEquals(amenity4.getAmenityID(), savedAmenity.getAmenityID());

    }
    @Test
    void a_create5() {
        String url = baseURL + "/create";
        ResponseEntity<Amenity> postResponse = restTemplate.postForEntity(url, amenity5, Amenity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Amenity savedAmenity = postResponse.getBody();
        System.out.println("Saved data:" + savedAmenity);
        assertEquals(amenity5.getAmenityID(), savedAmenity.getAmenityID());

    }
    @Test
    void a_create6() {
        String url = baseURL + "/create";
        ResponseEntity<Amenity> postResponse = restTemplate.postForEntity(url, amenity6, Amenity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Amenity savedAmenity = postResponse.getBody();
        System.out.println("Saved data:" + savedAmenity);
        assertEquals(amenity6.getAmenityID(), savedAmenity.getAmenityID());

    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + amenity1.getAmenityID();
        System.out.println("URL:" + url);
        ResponseEntity<Amenity> response = restTemplate.getForEntity(url, Amenity.class);
        assertEquals(amenity1.getAmenityID(),response.getBody().getAmenityID());
        System.out.println(response.getBody());

    }

    @Test
    void c_update() {
        Amenity updated = new Amenity.Builder().copy(amenity1).setName("Conditioner").build();
        String url = baseURL + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Amenity> response = restTemplate.postForEntity(url, updated, Amenity.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + amenity1.getAmenityID();
        System.out.println("URL:" + url);
        restTemplate.delete(url);
    }


    @Test
    void e_getall() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("Show all:" );
        System.out.println(response);
        System.out.println(response.getBody());
    }
}