/**
 * DietaryRequirementFactory.java
 * Factory class for the Dietary Requirement
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.util.Helper;

public class DietaryRequirementFactory {

    public static DietaryRequirement createDietaryRequirement(String dietaryRequirementID, String name, String specialRequirements) {

        if (Helper.isNullOrEmpty(dietaryRequirementID) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(specialRequirements))
            return null;

        String dietaryRequirementsID = Helper.generateID();

        return new DietaryRequirement.Builder().setDietaryRequirementID(dietaryRequirementID)
                .setDietaryRequirementID(dietaryRequirementID)
                .setName(name)
                .setSpecialRequirements(specialRequirements)
                .build();

    }
}
