package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.MealPlan;

public interface IMealPlanRepository extends JpaRepository<MealPlan, String> {
}
