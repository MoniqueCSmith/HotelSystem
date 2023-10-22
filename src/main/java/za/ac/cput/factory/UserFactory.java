/**
 * UserFactory.java
 * Factory class for the User
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserContact;
import za.ac.cput.util.Helper;

public class UserFactory {
    public static User buildUser(String firstName, String lastName, String address, String cellNo, String email){
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(address)) {
            return null;
        }

        UserContact userContact = UserContactFactory.buildUserContact(cellNo, email);


        return new User.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setUserContact(userContact)
                .build();
    }
}