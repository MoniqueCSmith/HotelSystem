/**
 * DietaryRequirementImplTest.java
 * Test class for Dietary Requirement service.
 * Author : Monique Casey Smith
 * Student Number: 217041701
 * Date : 10 June 2023
 */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.factory.DietaryRequirementFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class DietaryRequirementImplTest {

    private static DietaryRequirementImpl service = DietaryRequirementImpl.getService();
    private static DietaryRequirement dietaryRequirement = DietaryRequirementFactory.createDietaryRequirement
            ("307", "Lactose intolerant", "No dairy products.");
    @Test
    void a_create() {
        DietaryRequirement created = service.create(dietaryRequirement);
        assertEquals(dietaryRequirement.getDietaryRequirementID(), created.getDietaryRequirementID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        if (service != null) {
            DietaryRequirement read = service.read(dietaryRequirement);
            System.out.println("Read: " + read);
        } else {
            System.out.println("Service is null. Cannot read dietary requirement.");
        }
    }

    @Test
    void c_update() {
        DietaryRequirement updated = new DietaryRequirement.Builder().copy(dietaryRequirement)
                .setDietaryRequirementID("307")
                .setName("Lactose intolerant")
                .setSpecialRequirements("Substitute dairy ingredients with vegan options.")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }
}