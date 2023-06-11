/**
 * DietaryRequirementRepositoryTest.java
 * Repository Test for the Dietary Requirement
 * Author: Monique Casey Smith (217041701)
 * Date: 07 April 2023
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.factory.DietaryRequirementFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DietaryRequirementRepositoryTest {

    private static DietaryRequirementRepository repository = DietaryRequirementRepository.getRepository();
    private static DietaryRequirement dietaryRequirement = DietaryRequirementFactory.createDietaryRequirement
            ("Vegan", "Allergic to eggs.");

    @Test
    void a_create() {
        DietaryRequirement created = repository.create(dietaryRequirement);
        assertEquals(dietaryRequirement.getDietaryRequirementID(), created.getDietaryRequirementID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        DietaryRequirement read = repository.read(dietaryRequirement.getDietaryRequirementID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        DietaryRequirement updated = new DietaryRequirement.Builder().copy(dietaryRequirement)
                .setDietaryRequirementID("302")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(dietaryRequirement.getDietaryRequirementID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

}