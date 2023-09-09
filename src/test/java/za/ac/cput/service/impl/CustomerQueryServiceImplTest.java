package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.factory.CustomerQueryFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerQueryServiceImplTest {
    @Autowired
    private CustomerQueryServiceImpl service;
    private static CustomerQuery customerQuery = CustomerQueryFactory.buildCustomerQuery("Reservation Cancellation", "SmithJohn321@gmail.com","What is the cancellation process for a reservation?");

    @Test
    void a_create() {
        CustomerQuery create = service.create(customerQuery);
        assertEquals(customerQuery.getQueryID(), create.getQueryID());
        System.out.println("created" + create);
    }

    @Test
    void b_read() {
        CustomerQuery read = service.read(customerQuery.getQueryID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_delete() {
        boolean success = service.delete(customerQuery.getQueryID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}