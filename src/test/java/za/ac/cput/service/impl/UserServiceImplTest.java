/**
 * UserServiceImplTest.java
 * Test for the UserServiceImpl
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserContact;
import za.ac.cput.factory.UserContactFactory;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl service;
    private static UserContact userContact = UserContactFactory.buildUserContact("0769284755", "SmithJohn321@gmail.com");
    private static User user = UserFactory.buildUser("John", "Smith", "12 Zastron Road, Milnerton", userContact.getCellNo(), userContact.getEmail());
    @Test
    void a_create() {
        User create = service.create(user);
        assertEquals(user.getUserID(), create.getUserID());
        System.out.println("created" + create);
    }

    @Test
    void b_read() {
        User read = service.read(user.getUserID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        User newUser = new User.Builder().copy(user).setAddress("27 Loxton Road, Milnerton").build();
        User updated = service.update(newUser);
        assertEquals(newUser.getAddress(), updated.getAddress());
        System.out.println("Update" + updated);
    }

    @Test
    void d_delete() {
        boolean success = service.delete(user.getUserID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}