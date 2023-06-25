package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.MealPlan;
import za.ac.cput.util.factory.MealPlanFactory;
import za.ac.cput.service.impl.MealPlanServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/mealPlan")
public class MealPlanController {

    @Autowired
    private MealPlanServiceImpl mealPlanService;

    @PostMapping("/create")
    public MealPlan create(@RequestBody MealPlan mealPlan) {
        MealPlan created = MealPlanFactory.createMealPlan(mealPlan.getName(), mealPlan.getDescription(), mealPlan.getMealType(), mealPlan.getPrice(), mealPlan.getDietaryRequirement());
        return mealPlanService.create(created);
    }

    @GetMapping("/read/{id}")
    public MealPlan read(@PathVariable String id) {
        return mealPlanService.read(id);
    }

    @PostMapping("/update")
    public MealPlan update(@RequestBody MealPlan mealPlan) {
        return mealPlanService.update(mealPlan);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return mealPlanService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<MealPlan> getAll() {
        return mealPlanService.getAll();
    }
}

