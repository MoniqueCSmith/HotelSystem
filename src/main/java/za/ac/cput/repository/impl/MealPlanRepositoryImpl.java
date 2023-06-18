/**
 * MealPlanRepository.java
 * Repository class for the Meal Plan
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.repository.impl;

import za.ac.cput.domain.MealPlan;
import za.ac.cput.repository.IMealPlanRepository;

import java.util.HashSet;
import java.util.Set;

public class MealPlanRepositoryImpl implements IMealPlanRepository {

    private static MealPlanRepositoryImpl repository = null;
    private Set<MealPlan> mealPlanDB = null;

    private MealPlanRepositoryImpl() {
        mealPlanDB = new HashSet<MealPlan>();
    }

    public static MealPlanRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new MealPlanRepositoryImpl();
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
        for (MealPlan m : mealPlanDB) {
            if (m.getMealPlanID().equals(mealPlanID))
                return m;
        }
        return null;
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
