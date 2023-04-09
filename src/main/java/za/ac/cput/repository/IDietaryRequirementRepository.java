/**
 * IDietaryRequirementRepository.java
 * Interface Repository for the Dietary Requirement
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.repository;

import za.ac.cput.domain.DietaryRequirement;

import java.util.Set;

public interface IDietaryRequirementRepository extends IRepository <DietaryRequirement, String> {

    public Set<DietaryRequirement> getAll();
}
