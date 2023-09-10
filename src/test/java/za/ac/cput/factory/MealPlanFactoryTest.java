/**
 * MealPlanFactoryTest.java
 * Factory Test for the Meal Plan
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DietaryRequirementEnum;
import za.ac.cput.domain.MealPlan;

import static org.junit.jupiter.api.Assertions.*;

class MealPlanFactoryTest {

    @Test
    public void test() {

        MealPlan mealPlan = MealPlanFactory.createMealPlan("Vegan",
                "Breakfast burritos made with tofu.", "Breakfast", 80.00, DietaryRequirementEnum.VEGAN);
        assertNotNull(mealPlan);
        System.out.println(mealPlan.toString());

    }

}