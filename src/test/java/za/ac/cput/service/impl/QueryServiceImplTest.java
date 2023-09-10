/**
 * QueryServiceImplTest.java
 * Test for the QueryServiceImpl
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Query;
import za.ac.cput.factory.QueryFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class QueryServiceImplTest {
    @Autowired
    private QueryServiceImpl service;
    private static Query query = QueryFactory.buildQuery("Reservation Cancellation", "vdbsepp11111@gmail.com","What is the cancellation process for a reservation?");

    @Test
    void a_create() {
        Query create = service.create(query);
        assertEquals(query.getRefNo(), create.getRefNo());
        System.out.println("created" + create);
    }

    @Test
    void b_read() {
        Query read = service.read(query.getRefNo());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_delete() {
        boolean success = service.delete(query.getRefNo());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}