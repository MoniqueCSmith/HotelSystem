/* InvoiceControllerTest.java
 Controller Test for the Invoice class
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
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InvoiceControllerTest {

    private static Invoice invoice = InvoiceFactory.createInvoice("Single Room",1,2,
            0,1000.00,140.00,1000);
    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL= "http://localhost:8080/invoice";

    @Test
    void a_create() {
        String url= baseURL + "/create";
        ResponseEntity<Invoice> postResponse= restTemplate.postForEntity(url, invoice, Invoice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Invoice savedInvoice= postResponse.getBody();
        System.out.println("Saved data: " + savedInvoice);
        assertEquals(invoice.getInvoiceID(), savedInvoice.getInvoiceID());
    }

    @Test
    void b_read() {

        String url= baseURL + "/read/"+ invoice.getInvoiceID();
        System.out.println("URL:"+ url);
        ResponseEntity<Invoice> response= restTemplate.getForEntity(url, Invoice.class);
        assertEquals(invoice.getInvoiceID(), response.getBody().getInvoiceID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {

        Invoice updated= new Invoice.Builder().copy(invoice)
                .setNumAdults(1)
                .build();
        String url= baseURL + "/update";
        System.out.println("URL"+ url);
        System.out.println("Post data" + updated);
        ResponseEntity<Invoice> response= restTemplate.postForEntity(url,updated,Invoice.class);
        assertNotNull(response.getBody());
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