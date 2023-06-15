/**
 * CustomerContactControllerTest.java
 * Test class for the CustomerContactController
 * Author: Brandon Wise (220049173)
 * Date: 15 June 2023
 */
package za.ac.cput.controller;

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
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.factory.CustomerContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerContactControllerTest {
    private static CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0812685242","Ashtonw1234@gmail.com");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/customerContact";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<CustomerContact> postResponse = restTemplate.postForEntity(url, customerContact, CustomerContact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        CustomerContact savedCustomerContact = postResponse.getBody();
        System.out.println("Saved data:" + savedCustomerContact);
        assertEquals(customerContact.getCustomerContactID(), customerContact.getCustomerContactID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + customerContact.getCustomerContactID();
        System.out.println("URL:" + url);
        ResponseEntity<CustomerContact> response = restTemplate.getForEntity(url, CustomerContact.class);
        assertEquals(customerContact.getCustomerContactID(),response.getBody().getCustomerContactID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        CustomerContact updated = new CustomerContact.Builder().copy(customerContact).setCellNo("0762466432").build();
        String url = baseURL + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<CustomerContact> response = restTemplate.postForEntity(url, updated, CustomerContact.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url = baseURL + "/delete/" + customerContact.getCustomerContactID();
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