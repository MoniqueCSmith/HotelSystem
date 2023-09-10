/**
 * MealPlanFactoryTest.java
 * Factory Test for the Meal Plan
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.MealPlan;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static za.ac.cput.domain.DietaryRequirementEnum.VEGAN;

class MealPlanFactoryTest {

    @Test
    public void test() {

        MealPlan mealPlan = MealPlanFactory.createMealPlan("Vegan",
                "Breakfast burritos made with tofu.", "Breakfast", 80.00, VEGAN);
        assertNotNull(mealPlan);
        System.out.println(mealPlan);

    }

}