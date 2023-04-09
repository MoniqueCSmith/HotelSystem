package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Membership;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MembershipFactoryTest {
    @Test
    void createMembership() {

        Membership membership = MembershipFactory.buildMembership("ffloppy@gmail.com", "carrot","carrot","Fin","15-12-2000","0764589452","Male");
        System.out.println(membership);
        assertNotNull(membership);

    }
}
