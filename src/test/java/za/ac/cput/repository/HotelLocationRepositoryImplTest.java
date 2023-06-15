/* HotelLocationRepositoryTest.java
 Repository Test for the Hotel Location class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.HotelLocation;
import za.ac.cput.factory.HotelLocationFactory;
import za.ac.cput.repository.impl.HotelLocationRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class HotelLocationRepositoryImplTest {

    private static HotelLocationRepositoryImpl repository = HotelLocationRepositoryImpl.getRepository();
    private static HotelLocation hotelLocation= HotelLocationFactory.createHotelLocation("12 Nassua Street Clifton",
                                                "Cape Town", "Western Cape", 7650);

    @Test
    void a_create(){
        HotelLocation created= repository.create(hotelLocation);
        assertEquals(hotelLocation.getID(), created.getID());
        System.out.println("The object created: " + created);
    }
    @Test
    void b_read(){
        HotelLocation read= repository.read(hotelLocation.getID());
        assertNotNull(read);
        System.out.println("This has read: " + read);
    }

    @Test
    void c_update(){
        HotelLocation updated= new HotelLocation.Builder().copy(hotelLocation)
                .setAddress("9 Esenembe Road Farm")
                .setCity("Durban")
                .setProvince("KwaZulu-Natal")
                .setZipCode(4030)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("The updated hotel location is: " + updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(hotelLocation.getID());
                assertTrue(success);
                System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll(){
        System.out.println("Display all information: ");
        System.out.println(repository.getAll());
    }
}
