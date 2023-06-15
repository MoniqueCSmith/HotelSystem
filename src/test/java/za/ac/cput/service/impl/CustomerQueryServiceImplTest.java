/**
 * CustomerQueryServiceImplTest.java
 * Test class for the CustomerQueryServiceImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.factory.CustomerQueryFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class CustomerQueryServiceImplTest {
    private static CustomerQueryServiceImpl service = CustomerQueryServiceImpl.getService();
    private static CustomerQuery customerQuery = CustomerQueryFactory.buildCustomerQuery("Reservation Cancellation", "WiseBrandon321@gmail.com", "Good day, how can I cancel my reservation for Friday 12 May? I can no longer make it for then.");
    @Test
    void a_create() {
        CustomerQuery created = service.create(customerQuery);
        assertEquals(customerQuery.getQueryID(), created.getQueryID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        CustomerQuery read = service.read(customerQuery.getQueryID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }
    @Test
    void c_delete() {
        boolean success = service.delete(customerQuery.getQueryID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}