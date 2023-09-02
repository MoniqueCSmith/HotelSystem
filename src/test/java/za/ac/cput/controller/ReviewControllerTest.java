/**
 * ReviewControllerTest.java
 * Controller Test class for the Review
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
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewControllerTest {
    private static Review review = ReviewFactory.buildReview(5,"The best experience I've ever had!");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/review";

    @Test
    void a_create(){
        String url = baseURL + "/create";
        ResponseEntity<Review> postResponse = restTemplate.postForEntity(url, review, Review.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Review savedReview = postResponse.getBody();
        System.out.println("Saved data:" + savedReview);
        assertEquals(review.getReviewID(), savedReview.getReviewID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + review.getReviewID();
        System.out.println("URL:" + url);
        ResponseEntity<Review> response = restTemplate.getForEntity(url, Review.class);
        assertEquals(review.getReviewID(),response.getBody().getReviewID());
        System.out.println(response.getBody());
    }

    @Test
    @Disabled
    void c_delete() {
        String url = baseURL + "/delete/" + review.getReviewID();
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
