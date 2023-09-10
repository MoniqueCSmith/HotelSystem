package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.DietaryRequirementEnum;
import za.ac.cput.domain.MealPlan;
import za.ac.cput.factory.MealPlanFactory;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.domain.DietaryRequirementEnum.VEGAN;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class MealPlanServiceImplTest {

    @Autowired
    private MealPlanServiceImpl service;


    private static MealPlan mealPlan = MealPlanFactory.createMealPlan("Vegan", "Breakfast burritos made with tofu.", "Breakfast", 80.00, VEGAN);
    @Test
    void a_create() {
        MealPlan created = service.create(mealPlan);
        assertEquals(mealPlan.getMealPlanID(), created.getMealPlanID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        MealPlan read = service.read(mealPlan.getMealPlanID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        MealPlan newMealPlan = new MealPlan.Builder().copy(mealPlan).setPrice(85.00).build();
        MealPlan updated = service.update(newMealPlan);
        assertEquals(newMealPlan.getPrice(), updated.getPrice());
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = service.delete(mealPlan.getMealPlanID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }
}