/**
 * DietaryRequirementFactoryTest.java
 * Factory Test for the Dietary Requirement
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.util.factory.DietaryRequirementFactory;

import static org.junit.jupiter.api.Assertions.*;

class DietaryRequirementFactoryTest {

    @Test
    public void test() {
        DietaryRequirement dietaryRequirement = DietaryRequirementFactory.createDietaryRequirement("Vegan", "Allergic to seafood.");
        assertNotNull(dietaryRequirement);
        System.out.println(dietaryRequirement.toString());
    }

}