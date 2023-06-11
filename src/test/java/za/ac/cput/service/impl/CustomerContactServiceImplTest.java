/**
 * CustomerContactServiceImplTest.java
 * Test class for the CustomerContactServiceImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.factory.CustomerContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class CustomerContactServiceImplTest {
    private static CustomerContactServiceImpl service = CustomerContactServiceImpl.getService();
    private static CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0736432578", "WiseBrandon321@gmail.com");
    @Test
    void a_create() {
        CustomerContact created = service.create(customerContact);
        assertEquals(customerContact.getCustomerContactID(), created.getCustomerContactID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        CustomerContact read = service.read(customerContact);
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        CustomerContact updated = new CustomerContact.Builder().copy(customerContact)
                .setCellNo("0816938593")
                .setEmail("WiseBrandon123@gmail.com")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated:" + updated);
    }
    @Test
    void d_delete() {
        boolean success = service.delete(customerContact);
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }
    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}