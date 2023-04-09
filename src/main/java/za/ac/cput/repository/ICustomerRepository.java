/**
 * ICustomerRepository.java
 * Interface Repository for the Customer
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Customer;
import java.util.Set;

public interface ICustomerRepository extends IRepository<Customer, String>{
    Set<Customer> getAll();
}
