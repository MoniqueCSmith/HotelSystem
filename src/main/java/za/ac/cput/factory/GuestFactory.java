package za.ac.cput.factory;


import za.ac.cput.domain.Guest;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class GuestFactory {

    public static Guest createGuest (String firstName, String lastName, String address, String cellNo, String email) {

        User user = UserFactory.buildUser(firstName, lastName,address, cellNo, email);

        String guestID = Helper.generateGuestID();

        return new Guest.Builder()
                .setGuestID(guestID)
                .setUser(user)
                .build();
    }
}
