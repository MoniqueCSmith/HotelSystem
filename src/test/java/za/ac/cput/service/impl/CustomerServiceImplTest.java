package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.factory.CustomerContactFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl service;
    //private static CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0769284755", "SmithJohn321@gmail.com");
    private static Customer customer = CustomerFactory.buildCustomer("John", "Smith", "12 Zastron Road, Milnerton", true //, customerContact
    );
    @Test
    void a_create() {
        Customer create = service.create(customer);
        assertEquals(customer.getCustomerID(), create.getCustomerID());
        System.out.println("created" + create);
    }

    @Test
    void b_read() {
        Customer read = service.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        Customer newCustomer = new Customer.Builder().copy(customer).setAddress("27 Loxton Road, Milnerton").build();
        Customer updated = service.update(newCustomer);
        assertEquals(newCustomer.getAddress(), updated.getAddress());
        System.out.println("Update" + updated);
    }

    @Test
    void d_delete() {
        boolean success = service.delete(customer.getCustomerID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}