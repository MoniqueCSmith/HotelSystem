/**
 * MembershipServiceImplTest.java
 * Service Test class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Membership;
import za.ac.cput.factory.MembershipFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MembershipServiceImplTest {
    private static MembershipServiceImpl service = MembershipServiceImpl.getService();
    private static Membership membership = MembershipFactory.buildMembership("cconner@gmail.com","fish", "Corrie", "Conner", "0874561549", "Male");

    @Test
    void a_create() {
        Membership created = service.create(membership);
        assertEquals(membership.getMemberID(), created.getMemberID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Membership read = service.read(membership);
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Membership updated = new Membership.Builder().copy(membership)
                .setEmail("tthomas@gmail.com")
                .setPassword("potato")
                .setMembFirstName("Tommy")
                .setMembLastName("Thomas")
                .setPhoneNumber("0864798415")
                .setGender("Male")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated:" + updated);

    }

    @Test
    void d_delete() {
        boolean success = service.delete(membership);
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
