/**
 * CustomerServiceImpl.java
 * Service class for the CustomerImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepository;
import za.ac.cput.service.CustomerService;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private ICustomerRepository repository;
@Autowired
    private CustomerServiceImpl(ICustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
    return this.repository.save(customer);
    }

    @Override
    public Customer read(String customerID) {
    return this.repository.findById(customerID).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if(this.repository.existsById(customer.getCustomerID()))
            return this.repository.save(customer);
        return null;
    }

    @Override
    public boolean delete(String customerID) {
        if (this.repository.existsById(customerID)) {
            this.repository.deleteById(customerID);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return this.repository.findAll();
    }
}
