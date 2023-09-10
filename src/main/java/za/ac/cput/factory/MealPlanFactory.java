/**
 * MealPlanFactory.java
 * Factory class for the Meal Plan
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.DietaryRequirementEnum;
import za.ac.cput.domain.MealPlan;
import za.ac.cput.util.Helper;

public class MealPlanFactory {

    public static MealPlan createMealPlan (String name, String description, String mealType, double price, DietaryRequirementEnum dietaryRequirementEnum) {

        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description)
                || Helper.isNullOrEmpty(mealType) || Helper.isNullOrEmpty(String.valueOf(price)) || Helper.isNullOrEmpty(String.valueOf(dietaryRequirementEnum))){
            return null;
        }

        String mealPlanID = Helper.generateMealPlanID();

        return new MealPlan.Builder().setMealPlanID(mealPlanID)
                .setName(name)
                .setDescription(description)
                .setMealType(mealType)
                .setPrice(price)
                .setDietaryRequirementEnum(dietaryRequirementEnum)
                .build();
    }
}
