package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Guest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GuestFactoryTest {

    @Test
    public void test() {
        Guest guest = GuestFactory.createGuest("Damon", "Salvatore", "1420 Walnut Drive", "0846254695", "damonsalvatore@gmail.com");
        assertNotNull(guest);
        System.out.println(guest.toString());

    }
}