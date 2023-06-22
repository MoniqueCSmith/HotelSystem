/**
 * CustomerQueryControllerTest.java
 * Test class for the CustomerQueryController
 * Author: Brandon Wise (220049173)
 * Date: 15 June 2023
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
import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.util.factory.CustomerQueryFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerQueryControllerTest {
    private static CustomerQuery customerQuery = CustomerQueryFactory.buildCustomerQuery("Reservation Cancellation","Ashtonw1234@gmail.com", "Good day, how can I cancel my reservation for Friday 12 May? I can no longer make it for then.");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/customerQuery";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<CustomerQuery> postResponse = restTemplate.postForEntity(url, customerQuery, CustomerQuery.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        CustomerQuery savedCustomerQuery = postResponse.getBody();
        System.out.println("Saved data:" + savedCustomerQuery);
        assertEquals(customerQuery.getQueryID(), savedCustomerQuery.getQueryID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + customerQuery.getQueryID();
        System.out.println("URL:" + url);
        ResponseEntity<CustomerQuery> response = restTemplate.getForEntity(url, CustomerQuery.class);
        assertEquals(customerQuery.getQueryID(),response.getBody().getQueryID());
        System.out.println(response.getBody());
    }

    @Test
    @Disabled
    void c_delete() {
        String url = baseURL + "/delete/" + customerQuery.getQueryID();
        System.out.println("URL:" + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getall() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("Show all:" );
        System.out.println(response);
        System.out.println(response.getBody());
    }
}