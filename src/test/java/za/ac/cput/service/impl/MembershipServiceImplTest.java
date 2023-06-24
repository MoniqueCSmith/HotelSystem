package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Membership;
import za.ac.cput.util.factory.MembershipFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class MembershipServiceImplTest {

    @Autowired
    private MembershipServiceImpl service;

    private static Membership membership = MembershipFactory.buildMembership("plions@gmail.com","seaweed", "Paxton", "Lions", "0879543576", "male");

    @Test
    void a_create(){
        Membership create = service.create(membership);
        assertEquals(membership.getMemberID(), create.getMemberID());
        System.out.println("created" + create);
    }

    @Test
    void b_read() {
        Membership read = service.read(membership.getMemberID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        Membership newMembership = new Membership.Builder().copy(membership).setEmail("p.lions@gmail.com").build();
        Membership updated = service.update(newMembership);
        assertEquals(newMembership.getEmail(), updated.getEmail());
        System.out.println("Update" + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = service.delete(membership.getMemberID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}
