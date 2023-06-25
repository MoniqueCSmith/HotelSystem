package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.factory.CustomerContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerContactServiceImplTest {

    @Autowired
    private CustomerContactServiceImpl service;
    private static CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0769284755", "SmithJohn321@gmail.com");
    @Test
    void a_create() {
        CustomerContact create = service.create(customerContact);
        assertEquals(customerContact.getCustomerContactID(), create.getCustomerContactID());
        System.out.println("created" + create);
    }

    @Test
    void b_read() {
        CustomerContact read = service.read(customerContact.getCustomerContactID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        CustomerContact newCustomerContact = new CustomerContact.Builder().copy(customerContact).setCellNo("0672347474").build();
        CustomerContact updated = service.update(newCustomerContact);
        assertEquals(newCustomerContact.getCellNo(), updated.getCellNo());
        System.out.println("Update" + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = service.delete(customerContact.getCustomerContactID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}