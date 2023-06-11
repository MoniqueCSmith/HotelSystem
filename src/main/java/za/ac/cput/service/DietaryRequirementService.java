/**
 * DietaryRequirementService.java
 * Service interface for Dietary Requirement entity.
 * Author : Monique Casey Smith
 * Student Number: 217041701
 * Date : 10 June 2023
 */

package za.ac.cput.service;

import za.ac.cput.domain.DietaryRequirement;

import java.util.Set;

public interface DietaryRequirementService extends IService <DietaryRequirement, String> {
    Set<DietaryRequirement> getAll();
}
