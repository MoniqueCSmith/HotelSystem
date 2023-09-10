/**
 * UserContactFactoryTest.java
 * Factory Test for the UserContact
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.UserContact;

import static org.junit.jupiter.api.Assertions.*;

class UserContactFactoryTest {
    @Test
void createUserContact(){
    UserContact userContact = UserContactFactory.buildUserContact("0674758219", "vdbsepp1@gmail.com");
    assertNotNull(userContact);
    System.out.println(userContact);
}
}