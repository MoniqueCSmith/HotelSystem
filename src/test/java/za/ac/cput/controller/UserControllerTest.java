/**
 * UserControllerTest.java
 * Test class for the UserController
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
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserContact;
import za.ac.cput.factory.UserContactFactory;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    private static UserContact userContact = UserContactFactory.buildUserContact("0732685242","Ashtonw123@gmail.com");
    private static User user = UserFactory.buildUser("Ashton", "Williams", "10 Stable Road, Milnerton", userContact.getCellNo(), userContact.getEmail());
    private static User user2 = UserFactory.buildUser("Alison", "Williams", "10 Stable Road, Milnerton", userContact.getCellNo(), userContact.getEmail());
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/user";
    @Test
    void a_create1() {
        String url = baseURL + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        User savedUser = postResponse.getBody();
        System.out.println("Saved data:" + savedUser);
        assertEquals(user.getUserID(), savedUser.getUserID());
    }

    @Test
    void a_create2() {
        String url = baseURL + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user2, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        User savedUser = postResponse.getBody();
        System.out.println("Saved data:" + savedUser);
        assertEquals(user2.getUserID(), savedUser.getUserID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + user.getUserID();
        System.out.println("URL:" + url);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        assertEquals(user.getUserID(),response.getBody().getUserID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        User updated = new User.Builder().copy(user2).setFirstName("Kruben").build();
        String url = baseURL + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<User> response = restTemplate.postForEntity(url, updated, User.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + user.getUserID();
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