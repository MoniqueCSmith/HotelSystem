/**
 * CustomerQueryRepositoryTest.java
 * Repository Test for the CustomerQuery
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.factory.CustomerQueryFactory;
import za.ac.cput.repository.impl.CustomerQueryRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerQueryRepositoryTest {
    private static CustomerQueryRepositoryImpl repository = CustomerQueryRepositoryImpl.getRepository();
    private static CustomerQuery customerQuery = CustomerQueryFactory.buildCustomerQuery("Reservation Cancellation","JoshBrown@gmail.com", "Good day, how can I cancel my reservation for Friday 12 May? I can no longer make it for then.");

    @Test
    void a_create() {
        CustomerQuery created = repository.create(customerQuery);
        assertEquals(customerQuery.getQueryID(), created.getQueryID());
        System.out.println("Create:" + created);
    }
    @Test
    void b_read() {
        CustomerQuery read = repository.read(customerQuery.getQueryID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }
    @Test
    void c_update() {
        CustomerQuery updated = new CustomerQuery.Builder().copy(customerQuery).setTitle("Reservation Cancellation")
                .setEmail("JoshBrown1@gmail.com")
                .setDescription("Good day, how can I cancel my reservation for Friday 12 May? I can no longer make it for then.")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }
    @Test
    void d_delete() {
        boolean success = repository.delete(customerQuery.getQueryID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }
    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}