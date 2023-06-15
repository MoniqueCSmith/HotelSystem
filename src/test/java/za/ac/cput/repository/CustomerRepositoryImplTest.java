/**
 * CustomerRepositoryTest.java
 * Repository Test for the Customer
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.factory.CustomerContactFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.repository.impl.CustomerRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerRepositoryImplTest {
        private static CustomerRepositoryImpl repository = CustomerRepositoryImpl.getRepository();
        private static CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0843758392", "joshbrown@gmail.com");
        private static Customer customer = CustomerFactory.buildCustomer("Josh","Brown", "10 Woodbridge Road, Milnerton", false, customerContact);

        @Test
        void a_create() {
            Customer created = repository.create(customer);
            assertEquals(customer.getCustomerID(), created.getCustomerID());
            System.out.println("Create:" + created);
        }
        @Test
        void b_read() {
            Customer read = repository.read(customer.getCustomerID());
            assertNotNull(read);
            System.out.println("Read:" + read);
        }
        @Test
        void c_update() {
            Customer updated = new Customer.Builder().copy(customer).setFirstName("Josh")
                    .setLastName("Brown")
                    .setAddress("11 King Street, Edgemead")
                    .setHasMembership(true)
                    .setCustomerContact(customerContact)
                    .build();
            assertNotNull(repository.update(updated));
            System.out.println("Updated:" + updated);
        }
        @Test
        void d_delete() {
            boolean success = repository.delete(customer.getCustomerID());
            assertTrue(success);
            System.out.println("Deleted:" + success);
        }
        @Test
        void e_getAll() {
            System.out.println("Show all:");
            System.out.println(repository.getAll());
        }
    }