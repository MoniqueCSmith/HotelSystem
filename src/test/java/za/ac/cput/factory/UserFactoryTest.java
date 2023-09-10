/**
 * UserFactoryTest.java
 * Factory Test for the User
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserContact;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserFactoryTest {
    @Test
    void createUser(){
        UserContact userContact = UserContactFactory.buildUserContact("0783545275","vdbsepp1@gmail.com");
        User user = UserFactory.buildUser("Alison", "Williams","10 Loop Street, Table View", userContact.getCellNo(), userContact.getEmail());
        assertNotNull(user);
        System.out.println(user);
    }
}