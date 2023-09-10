/**
 * MealPlanServiceImpl.java
 * Service class for Dietary Requirement entity.
 * Author : Monique Casey Smith
 * Student Number: 217041701
 * Date : 10 June 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.MealPlan;
import za.ac.cput.repository.IMealPlanRepository;
import za.ac.cput.service.MealPlanService;

import java.util.List;

@Service
public class MealPlanServiceImpl implements MealPlanService {

    private IMealPlanRepository repository;

    @Autowired
    private MealPlanServiceImpl(IMealPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public MealPlan create(MealPlan mealPlan) {
        return this.repository.save(mealPlan);
    }

    @Override
    public MealPlan read(String mealPlanID) {
        return this.repository.findById(mealPlanID).orElse(null);
    }

    @Override
    public MealPlan update(MealPlan mealPlan) {
        if (this.repository.existsById(mealPlan.getMealPlanID())) {
            return this.repository.save(mealPlan);
        }
        return null;
    }

    @Override
    public boolean delete(String mealPlanID) {
        if (this.repository.existsById(mealPlanID)) {
            this.repository.deleteById(mealPlanID);
            return true;
        }
        return false;
    }

    @Override
    public List<MealPlan> getAll() {
        return this.repository.findAll();
    }
}
