/**
 * CustomerService.java
 * Service class for the Customer
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService extends IService <Customer, String>{
    List<Customer> getAll();
}
