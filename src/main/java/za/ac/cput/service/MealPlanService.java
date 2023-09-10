/**
 * MealPlanService.java
 * Service interface for Meal Plan entity.
 * Author : Monique Casey Smith
 * Student Number: 217041701
 * Date : 10 June 2023
 */

package za.ac.cput.service;

import za.ac.cput.domain.MealPlan;

import java.util.List;

public interface MealPlanService extends IService <MealPlan, String> {
    List<MealPlan> getAll();
}
