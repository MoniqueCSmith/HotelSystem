/**
 * MealPlanFactoryTest.java
 * Factory Test for the Meal Plan
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.domain.MealPlan;
import za.ac.cput.util.factory.DietaryRequirementFactory;
import za.ac.cput.util.factory.MealPlanFactory;

import static org.junit.jupiter.api.Assertions.*;

class MealPlanFactoryTest {

    @Test
    public void test() {
        DietaryRequirement dietaryRequirement = DietaryRequirementFactory.createDietaryRequirement("Vegan", "Allergic to eggs");
        MealPlan mealPlan = MealPlanFactory.createMealPlan("Vegan",
                "Breakfast burritos made with tofu.", "Breakfast", 80.00, dietaryRequirement);
        assertNotNull(mealPlan);
        System.out.println(mealPlan.toString());

    }

}