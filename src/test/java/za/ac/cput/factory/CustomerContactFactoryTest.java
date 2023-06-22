/**
 * CustomerContactFactoryTest.java
 * Factory Test for the CustomerContact
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.util.factory.CustomerContactFactory;

import static org.junit.jupiter.api.Assertions.*;

class CustomerContactFactoryTest {
    @Test
void createCustomerContact(){
    CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0674758219", "vdbsepp1@gmail.com");
    assertNotNull(customerContact);
    System.out.println(customerContact);
}
}