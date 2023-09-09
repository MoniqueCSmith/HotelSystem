/**
 * MembershipFactory.java
 * Factory class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Membership;
import za.ac.cput.util.Helper;

public class MembershipFactory {
    public static Membership buildMembership(String email, String password, String membFirstName, String membLastName, String phoneNumber, String gender) {
        if (Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(membFirstName) || Helper.isNullOrEmpty(membLastName)  || Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(gender)) {
            return null;
        }

        if(!Helper.isValidEmail(email)){
            return null;
        }


        String memberID = Helper.generateID();
        return new Membership.Builder()
                .setMemberID(memberID)
                .setEmail(email)
                .setPassword(password)
                .setMembFirstName(membFirstName)
                .setMembLastName(membLastName)
                .setPhoneNumber(phoneNumber)
                .setGender(gender)
                .build();
    }
}
