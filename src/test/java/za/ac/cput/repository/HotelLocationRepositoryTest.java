package za.ac.cput.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.HotelLocation;
import za.ac.cput.factory.HotelLocationFactory;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HotelLocationRepositoryTest {
    private static HotelLocationRepository repository = HotelLocationRepository.getRepository();
    private static HotelLocation hotelLocation = HotelLocationFactory.createHotelLocation("14 Nassua Street Bothasig", "Cape Town",
            "Western Cape", 731);
    @Test
    void create() {
        HotelLocation created = repository.create(hotelLocation);
        assertNotNull(created, "Failed to create HotelLocation object");
        assertEquals(created.getHotelCode(), hotelLocation.getHotelCode());
        System.out.println("This has been created: " + created);
    }

    @Test
    void read() {
        HotelLocation read = repository.read(hotelLocation.getHotelCode());
        assertNull(read, "Failed to read HotelLocation object");
        System.out.println("This has been read: " + read);
    }

    @Test
    void update() {
        HotelLocation updated = new HotelLocation.Builder().copy(hotelLocation)
                .setHotelAddress("456 Short Street")
                .setHotelCity("Durban")
                .setHotelProvince("Eastern Cape")
                .setHotelZipCode(6901)
                .build();

        assertNull(repository.update(updated));
        System.out.println("This has been updated: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(hotelLocation.getHotelCode());
        assertTrue(deleted);
        System.out.println("Deleted: " + true);
    }

    @Test
    void getAll() {
        System.out.println("All hotels: " + repository.getAll());
    }

}
