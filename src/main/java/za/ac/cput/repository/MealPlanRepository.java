/**
 * MealPlanRepository.java
 * Repository class for the Meal Plan
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.repository;

import za.ac.cput.domain.MealPlan;

import java.util.HashSet;
import java.util.Set;

public class MealPlanRepository implements IMealPlanRepository {

    private static MealPlanRepository repository = null;
    private Set<MealPlan> mealPlanDB = null;

    private MealPlanRepository() {
        mealPlanDB = new HashSet<MealPlan>();
    }

    public static MealPlanRepository getRepository() {
        if (repository == null) {
            repository = new MealPlanRepository();
        }
        return repository;
    }

    @Override
    public MealPlan create(MealPlan mealPlan) {
        boolean success = mealPlanDB.add(mealPlan);
        if (!success)
            return null;
        return mealPlan;
    }

    @Override
    public MealPlan read(String mealPlanID) {
        MealPlan mealPlan = mealPlanDB.stream()
                .filter(e -> e.getMealPlanID().equals(mealPlanID))
                .findAny()
                .orElse(null);
        return mealPlan;
    }

    @Override
    public MealPlan update(MealPlan mealPlan) {
        MealPlan oldMealPlan = read(mealPlan.getMealPlanID());
        if (oldMealPlan != null) {
            mealPlanDB.remove(oldMealPlan);
            mealPlanDB.add(mealPlan);
            return mealPlan;
        }
        return null;
    }

    @Override
    public boolean delete(String mealPlanID) {
        MealPlan mealPlanToDelete = read(mealPlanID);
        if (mealPlanToDelete == null)
            return false;
        mealPlanDB.remove(mealPlanToDelete);
        return true;
    }

    @Override
    public Set<MealPlan> getAll() {
        return mealPlanDB;
    }
}
