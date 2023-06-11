/**
 * MealPlanFactory.java
 * Factory class for the Meal Plan
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.domain.MealPlan;
import za.ac.cput.util.Helper;

public class MealPlanFactory {

    public static MealPlan createMealPlan (String name, String description, String mealType, double price, DietaryRequirement dietaryRequirement) {

        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description)
                || Helper.isNullOrEmpty(mealType) || Helper.isNullOrEmpty(String.valueOf(price)))
            return null;

        String mealPlanID = Helper.generateID();

        return new MealPlan.Builder().setMealPlanID(mealPlanID)
                .setName(name)
                .setDescription(description)
                .setMealType(mealType)
                .setPrice(price)
                .setDietaryRequirement(dietaryRequirement)
                .build();
    }
}
