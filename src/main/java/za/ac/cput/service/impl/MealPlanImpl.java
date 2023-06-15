/**
 * MealPlanImpl.java
 * Service class for Dietary Requirement entity.
 * Author : Monique Casey Smith
 * Student Number: 217041701
 * Date : 10 June 2023
 */

package za.ac.cput.service.impl;

import za.ac.cput.domain.MealPlan;
import za.ac.cput.repository.impl.MealPlanRepositoryImpl;
import za.ac.cput.service.MealPlanService;

import java.util.Set;

public class MealPlanImpl implements MealPlanService {

    private static MealPlanImpl service = null;
    private static MealPlanRepositoryImpl repository = null;

    private MealPlanImpl() {
        if(repository == null) {
            repository = MealPlanRepositoryImpl.getRepository();
        }
    }

    public static MealPlanImpl getService() {
        if (service == null) {
            service = new MealPlanImpl();
        }
        return service;
    }

    @Override
    public MealPlan create(MealPlan mealPlan) {
        return repository.create(mealPlan);
    }

    @Override
    public MealPlan read(String mealPlanID) {
        return repository.read(mealPlanID);
    }

    @Override
    public MealPlan update(MealPlan description) {
        return repository.update(description);
    }

    @Override
    public boolean delete(String mealPlanID) {
        return repository.delete(mealPlanID);
    }

    @Override
    public Set<MealPlan> getAll() {
        return repository.getAll();
    }
}
