package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.domain.MealPlan;
import za.ac.cput.factory.DietaryRequirementFactory;
import za.ac.cput.factory.MealPlanFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MealPlanControllerTest {

    private static DietaryRequirement dietaryRequirement = DietaryRequirementFactory.createDietaryRequirement("Lactose intolerant", "Substitute all dairy products.");
    private static MealPlan mealPlan = MealPlanFactory.createMealPlan("BLT Sandwich", "Toasted rye bread with bacon, lettuce, tomato, and mayo.", "Breakfast", 55.00, dietaryRequirement);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/mealPlan";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<MealPlan> postResponse = restTemplate.postForEntity(url, mealPlan, MealPlan.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        MealPlan savedMealPlan = postResponse.getBody();
        System.out.println("Saved data: " + savedMealPlan);
        assertEquals(mealPlan.getMealPlanID(), savedMealPlan.getMealPlanID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + mealPlan.getMealPlanID();
        System.out.println("URL: " + url);
        ResponseEntity<MealPlan> response = restTemplate.getForEntity(url, MealPlan.class);
        assertEquals(mealPlan.getMealPlanID(), response.getBody().getMealPlanID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        MealPlan updated = new MealPlan.Builder().copy(mealPlan).setPrice(64.00).build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<MealPlan> response = restTemplate.postForEntity(url, updated, MealPlan.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + mealPlan.getMealPlanID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}