/**
 * QueryFactoryTest.java
 * Factory Test for the Query
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Query;

import static org.junit.jupiter.api.Assertions.*;

class QueryFactoryTest {
    @Test
    void createQuery(){
        Query query = QueryFactory.buildQuery("Reservation Cancellation", "vdbsepp11111111111111@gmail.com","What is the cancellation process for a reservation?");
        assertNotNull(query);
        System.out.println(query);
    }
}