/**
 * MemberFactoryTest.java
 * Factory Test class for the Member
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Member;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MemberFactoryTest {
    @Test
    void createMember() {

        Member member = MemberFactory.buildMember("ffloppy", "carrot");
        System.out.println(member);
        assertNotNull(member);

    }
}
