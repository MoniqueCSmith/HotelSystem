/**
 * MemberFactory.java
 * Factory class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Member;
import za.ac.cput.util.Helper;
import za.ac.cput.domain.User;

public class MemberFactory {
    public static Member buildMember(String username, String password, String firstName, String lastName, String address, String cellNo, String email) {
        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        User user = UserFactory.buildUser(firstName, lastName,address, cellNo, email);

        String memberID = Helper.generateMemberID();
        return new Member.Builder()
                .setMemberID(memberID)
                .setUser(user)
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}
