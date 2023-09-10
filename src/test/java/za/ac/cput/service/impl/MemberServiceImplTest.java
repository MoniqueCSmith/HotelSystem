/**
 * MemberServiceImplTest.java
 * Service Test class for the Member
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Member;
import za.ac.cput.factory.MemberFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    private MemberServiceImpl service;

    private static Member member = MemberFactory.buildMember("plions","seaweed");

    @Test
    void a_create(){
        Member create = service.create(member);
        assertEquals(member.getMemberID(), create.getMemberID());
        System.out.println("created" + create);
    }

    @Test
    void b_read() {
        Member read = service.read(member.getMemberID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        Member newMember = new Member.Builder().copy(member).setUsername("p.lions").build();
        Member updated = service.update(newMember);
        assertEquals(newMember.getUsername(), updated.getUsername());
        System.out.println("Update" + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = service.delete(member.getMemberID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}
