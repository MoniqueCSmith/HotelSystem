package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Membership;
import za.ac.cput.factory.MembershipFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MembershipRepositoryTest {
    private static MembershipRepository repository = MembershipRepository.getRepository();
    private static Membership membership = MembershipFactory.buildMembership("cconner@gmail.com","fishie","Corrie","Conner", "13-08-1999", "0874561549", "Male");

    @Test
    void a_create() {
        Membership created = repository.create(membership);
        assertEquals(membership.getMemberID(), created.getMemberID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Membership read = repository.read(membership.getMemberID());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Membership updated = new Membership.Builder().copy(membership)
                .setPassword("potato")
                .setEmail("tthomas@gmail.com")
                .setMembFirstName("Tommy")
                .setMembLastName("Thomas")
                .setDateOfBirth("13-02-1997")
                .setPhoneNumber("0864798415")
                .setGender("Male")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated:" + updated);

    }

    @Test
    void d_delete() {
        boolean success = repository.delete(membership.getMemberID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}
