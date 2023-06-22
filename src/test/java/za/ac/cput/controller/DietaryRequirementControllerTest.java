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
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.util.factory.DietaryRequirementFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DietaryRequirementControllerTest {

    private static DietaryRequirement dietaryRequirement = DietaryRequirementFactory.createDietaryRequirement("Lactose intolerant", "Substitute all dairy products.");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/dietaryRequirement";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<DietaryRequirement> postResponse = restTemplate.postForEntity(url, dietaryRequirement, DietaryRequirement.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        DietaryRequirement savedDietaryRequirement = postResponse.getBody();
        System.out.println("Saved data: " + savedDietaryRequirement);
        assertEquals(dietaryRequirement.getDietaryRequirementID(), savedDietaryRequirement.getDietaryRequirementID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + dietaryRequirement.getDietaryRequirementID();
        System.out.println("URL: " + url);
        ResponseEntity<DietaryRequirement> response = restTemplate.getForEntity(url, DietaryRequirement.class);
        assertEquals(dietaryRequirement.getDietaryRequirementID(), response.getBody().getDietaryRequirementID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        DietaryRequirement updated = new DietaryRequirement.Builder().copy(dietaryRequirement).setName("Vegan").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<DietaryRequirement> response = restTemplate.postForEntity(url, updated, DietaryRequirement.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}