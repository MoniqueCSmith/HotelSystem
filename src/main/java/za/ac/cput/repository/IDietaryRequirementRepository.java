/**
 * IDietaryRequirementRepository.java
 * Interface Repository for the Dietary Requirement
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.DietaryRequirement;

@Repository
public interface IDietaryRequirementRepository extends JpaRepository<DietaryRequirement, String> {
}
