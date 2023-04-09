/**
 * CustomerQueryFactoryTest.java
 * Factory Test for the CustomerQuery
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CustomerQuery;

import static org.junit.jupiter.api.Assertions.*;

class CustomerQueryFactoryTest {
    @Test
    void createCustomerQuery(){
        CustomerQuery customerQuery = CustomerQueryFactory.buildCustomerQuery("Reservation Cancellation", "vdbsepp1@gmail.com","What is the cancellation process for a reservation?");
        assertNotNull(customerQuery);
        System.out.println(customerQuery);
    }
}