package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Guest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GuestFactoryTest {

    @Test
    public void test() {
        Guest guest = GuestFactory.createGuest();
        assertNotNull(guest);
        System.out.println(guest.toString());

    }
}