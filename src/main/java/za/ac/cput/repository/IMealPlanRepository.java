package za.ac.cput.repository;

import za.ac.cput.domain.MealPlan;

import java.util.Set;

public interface IMealPlanRepository extends IRepository <MealPlan, String> {

    public Set<MealPlan> getAll();


}
