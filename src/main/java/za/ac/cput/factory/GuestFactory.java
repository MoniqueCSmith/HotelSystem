package za.ac.cput.factory;


import za.ac.cput.domain.Guest;
import za.ac.cput.util.Helper;

public class GuestFactory {

    public static Guest createGuest () {

        String guestID = Helper.generateGuestID();

        return new Guest.Builder().setGuestID(guestID).build();
    }
}
