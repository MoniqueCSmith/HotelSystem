/**
 * MealPlanImplTest.java
 * Test class for Meal Plan service.
 * Author : Monique Casey Smith
 * Student Number: 217041701
 * Date : 10 June 2023
 */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.domain.MealPlan;
import za.ac.cput.factory.DietaryRequirementFactory;
import za.ac.cput.factory.MealPlanFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MealPlanImplTest {

    private static MealPlanImpl service = MealPlanImpl.getService();
    private static DietaryRequirement dietaryRequirement = DietaryRequirementFactory.createDietaryRequirement
            ("204", "Vegan", "Allergic to eggs");
    private static MealPlan mealPlan = MealPlanFactory.createMealPlan
            ("104", "Vegan", "Vegan omelette with mushrooms and spinach.", "Breakfast", 62.00, dietaryRequirement);
    @Test
    void a_create() {
        MealPlan created = service.create(mealPlan);
        assertEquals(mealPlan.getMealPlanID(), created.getMealPlanID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        MealPlan read = service.read(mealPlan);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        MealPlan updated = new MealPlan.Builder()
                .copy(mealPlan)
                .setMealPlanID("104")
                .setName("Vegan")
                .setDescription("Vegan omelette with mushrooms and spinach.")
                .setMealType("Breakfast")
                .setPrice(68.00)
                .setDietaryRequirement(dietaryRequirement)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = service.delete(mealPlan);
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }
}