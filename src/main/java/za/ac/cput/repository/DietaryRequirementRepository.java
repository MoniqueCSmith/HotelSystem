/**
 * DietaryRequirementRepository.java
 * Repository class for the Dietary Requirement
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.repository;

import za.ac.cput.domain.DietaryRequirement;

import java.util.HashSet;
import java.util.Set;

public class DietaryRequirementRepository implements IDietaryRequirementRepository {

    private static DietaryRequirementRepository repository = null;
    private Set<DietaryRequirement> dietaryRequirementDB = null;

    private DietaryRequirementRepository() {
        dietaryRequirementDB = new HashSet<DietaryRequirement>();
    }

    public static DietaryRequirementRepository getRepository() {
        if (repository == null) {
            repository = new DietaryRequirementRepository();
        }
        return repository;
    }

    @Override
    public DietaryRequirement create(DietaryRequirement dietaryRequirement) {
        boolean success = dietaryRequirementDB.add(dietaryRequirement);
        if (!success)
            return null;
        return dietaryRequirement;
    }

    @Override
    public DietaryRequirement read(String dietaryRequirementsID) {
        DietaryRequirement dietaryRequirement = dietaryRequirementDB.stream()
                .filter(e -> e.getDietaryRequirementID().equals(dietaryRequirementsID))
                .findAny()
                .orElse(null);
        return dietaryRequirement;
    }

    @Override
    public DietaryRequirement update(DietaryRequirement dietaryRequirement) {
        DietaryRequirement oldDietaryRequirement = read(dietaryRequirement.getDietaryRequirementID());
        if (oldDietaryRequirement != null) {
            dietaryRequirementDB.remove(oldDietaryRequirement);
            dietaryRequirementDB.add(dietaryRequirement);
            return dietaryRequirement;
        }
        return dietaryRequirement;
    }

    @Override
    public boolean delete(String dietaryRequirementsID) {
        DietaryRequirement dietaryRequirementToDelete = read(dietaryRequirementsID);
        if (dietaryRequirementToDelete == null)
            return false;
        dietaryRequirementDB.remove(dietaryRequirementToDelete);
        return true;
    }

    @Override
    public Set<DietaryRequirement> getAll() {
        return dietaryRequirementDB;
    }
}
