/**
 * MemberFactory.java
 * Factory class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Member;
import za.ac.cput.util.Helper;

public class MemberFactory {
    public static Member buildMember(String username, String password) {
        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        if(!Helper.isValidEmail(username)){
            return null;
        }


        String memberID = Helper.generateID();
        return new Member.Builder()
                .setMemberID(memberID)
                .setUsername(username)
                .build();
    }
}
