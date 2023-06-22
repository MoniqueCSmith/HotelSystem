/**
 * MembershipFactoryTest.java
 * Factory Test class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Membership;
import za.ac.cput.util.factory.MembershipFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MembershipFactoryTest {
    @Test
    void createMembership() {

        Membership membership = MembershipFactory.buildMembership("ffloppy@gmail.com", "carrot","carrot","Fin","0764589452","Male");
        System.out.println(membership);
        assertNotNull(membership);

    }
}
