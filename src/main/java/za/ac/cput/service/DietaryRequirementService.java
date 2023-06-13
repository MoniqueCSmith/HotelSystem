/**
 * DietaryRequirementService.java
 * Service interface for Dietary Requirement entity.
 * Author : Monique Casey Smith
 * Student Number: 217041701
 * Date : 10 June 2023
 */

package za.ac.cput.service;

import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.domain.Invoice;

import java.util.Set;

public interface DietaryRequirementService {
    DietaryRequirement create(DietaryRequirement dietaryRequirement);
    DietaryRequirement read(String id);
    DietaryRequirement update(DietaryRequirement dietaryRequirement);
    Set<DietaryRequirement> getAll();
}
