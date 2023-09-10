/**
 * UserContactFactory.java
 * Factory class for the UserContact
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.UserContact;
import za.ac.cput.util.Helper;

public class UserContactFactory {
    public static UserContact buildUserContact(String cellNo, String email) {
        if (Helper.isNullOrEmpty(cellNo) || Helper.isNullOrEmpty(email)) {
            return null;
        }
        if(!Helper.isValidEmail(email)) {
            return null;
        }
        if(!Helper.isValidCellNo(cellNo)) {
            return null;
        }

        return new UserContact.Builder()
                .setCellNo(cellNo)
                .setEmail(email)
                .build();
    }
}
