/**
 * CustomerServiceImplTest.java
 * Test class for the CustomerServiceImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerContactFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.domain.CustomerContact;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class CustomerServiceImplTest {

    private static CustomerServiceImpl service = CustomerServiceImpl.getService();
    private static CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0738395832","WiseBrandon123@gmail.com");
    private static Customer customer = CustomerFactory.buildCustomer("Brandon", "Wise", "7 Beach Road, Tableview", true, customerContact);
    @Test
    void a_create() {
        Customer created = service.create(customer);
        assertEquals(customer.getCustomerID(), created.getCustomerID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Customer read = service.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer)
                .setFirstName("Brandon")
                .setLastName("Wise")
                .setAddress("12 Long Street, Tableview")
                .setHasMembership(false)
                .setCustomerContact(customerContact)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void d_delete() {
        boolean success = service.delete(customer.getCustomerID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}