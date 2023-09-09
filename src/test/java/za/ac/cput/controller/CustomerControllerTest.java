/**
 * CustomerControllerTest.java
 * Test class for the CustomerController
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
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.factory.CustomerContactFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {
    private static CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0732685242","Ashtonw123@gmail.com");
    private static Customer customer = CustomerFactory.buildCustomer("Ashton", "Williams", "10 Stable Road, Milnerton", true, customerContact);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/customer";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Customer savedCustomer = postResponse.getBody();
        System.out.println("Saved data:" + savedCustomer);
        assertEquals(customer.getCustomerID(), savedCustomer.getCustomerID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + customer.getCustomerID();
        System.out.println("URL:" + url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertEquals(customer.getCustomerID(),response.getBody().getCustomerID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer).setHasMembership(false).build();
        String url = baseURL + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, updated, Customer.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + customer.getCustomerID();
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