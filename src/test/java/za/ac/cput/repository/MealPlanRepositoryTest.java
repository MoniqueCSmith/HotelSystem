/**
 * MealPlanRepositoryTest.java
 * Repository Test for the Meal Plan
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.domain.MealPlan;
import za.ac.cput.factory.DietaryRequirementFactory;
import za.ac.cput.factory.MealPlanFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MealPlanRepositoryTest {
    private static MealPlanRepository repository = MealPlanRepository.getRepository();
    private static DietaryRequirement dietaryRequirement = DietaryRequirementFactory.createDietaryRequirement
            ("Vegan", "Allergic to eggs");
    private static MealPlan mealPlan = MealPlanFactory.createMealPlan("Vegetarian",
            "Greek salad with a side of corn.", "Lunch", 65.00, dietaryRequirement);

    @Test
    void a_create() {
        MealPlan created = repository.create(mealPlan);
        assertEquals(mealPlan.getMealPlanID(), created.getMealPlanID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        MealPlan read = repository.read(mealPlan.getMealPlanID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        MealPlan updated = new MealPlan.Builder()
                .copy(mealPlan)
                .setMealPlanID("102")
                .setName("Vegetarian")
                .setDescription("Greek salad with a side of corn.")
                .setMealType("Lunch")
                .setPrice(72.00)
                .setDietaryRequirement(dietaryRequirement)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(mealPlan.getMealPlanID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}