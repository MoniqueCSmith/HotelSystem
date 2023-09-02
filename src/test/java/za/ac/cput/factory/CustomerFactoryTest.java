/**
 * CustomerFactoryTest.java
 * Factory Test for the Customer
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerContact;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerFactoryTest {
    @Test
    void createCustomer(){
        //CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0783545275","vdbsepp1@gmail.com");
        Customer customer = CustomerFactory.buildCustomer("Alison", "Williams","10 Loop Street, Table View",true //, customerContact
                );
        assertNotNull(customer);
        System.out.println(customer);
    }
}