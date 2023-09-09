/**
 * MembershipControllerTest.java
 * Controller Test class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 16 June 2023
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
import za.ac.cput.domain.Membership;
import za.ac.cput.factory.MembershipFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MembershipControllerTest {

    private static Membership membership = MembershipFactory.buildMembership("jordant@gmail.com", "JT254", "Jordan", "Tonny", "0897451684", "Male");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/membership";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Membership> postResponse = restTemplate.postForEntity(url, membership, Membership.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Membership savedMembership = postResponse.getBody();
        System.out.println("Saved data:" + savedMembership);
        assertEquals(membership.getMemberID(), savedMembership.getMemberID());

    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + membership.getMemberID();
        System.out.println("URL:" + url);
        ResponseEntity<Membership> response = restTemplate.getForEntity(url, Membership.class);
        assertEquals(membership.getMemberID(),response.getBody().getMemberID());
        System.out.println(response.getBody());

    }

    @Test
    void c_update() {
        Membership updated = new Membership.Builder().copy(membership).setPassword("Jordan012T").build();
        String url = baseURL + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Membership> response = restTemplate.postForEntity(url, updated, Membership.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + membership.getMemberID();
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
