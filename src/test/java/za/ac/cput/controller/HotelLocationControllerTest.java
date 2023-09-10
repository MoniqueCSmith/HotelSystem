/* HotelLocationControllerTest.java
 Controller Test for the Hotel Location class
 Author: Ashton Williams (220468478)
 Date: 15 June 2023
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
import za.ac.cput.domain.HotelLocation;
import za.ac.cput.factory.HotelLocationFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HotelLocationControllerTest {

    private static HotelLocation hotelLocation= HotelLocationFactory.createHotelLocation("89 Nassau Street Bothasig", "Cape Town", "Gauteng", 7441);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL= "http://localhost:8080/hotellocation";
    @Test
    void a_create() {
        String url= baseURL + "/create";
        ResponseEntity<HotelLocation> postResponse = restTemplate.postForEntity(url, hotelLocation, HotelLocation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        HotelLocation savedHotelLocation= postResponse.getBody();
        System.out.println("Saved data: " + savedHotelLocation);
        assertEquals(hotelLocation.getID(), savedHotelLocation.getID());
    }

    @Test
    void b_read() {

        String url= baseURL + "/read/"+ hotelLocation.getID();
        System.out.println("URL:"+ url);
        ResponseEntity<HotelLocation> response= restTemplate.getForEntity(url, HotelLocation.class);
        assertEquals(hotelLocation.getID(), response.getBody().getID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        HotelLocation updated= new HotelLocation.Builder().copy(hotelLocation)
                    .setProvince("Western Cape")
                    .build();
        String url= baseURL + "/update";
        System.out.println("URL"+ url);
        System.out.println("Post data" + updated);
        ResponseEntity<HotelLocation> response= restTemplate.postForEntity(url, updated, HotelLocation.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url= baseURL+ "/delete/" + hotelLocation.getID();
        System.out.println("URL:  " + url);
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