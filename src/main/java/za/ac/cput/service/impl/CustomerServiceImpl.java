/**
 * CustomerServiceImpl.java
 * Service class for the CustomerImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.CustomerService;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService {
    private static CustomerServiceImpl service = null;
    private CustomerRepository repository = null;

    private CustomerServiceImpl() {
        if(repository == null) {
            repository = CustomerRepository.getRepository();
        }
    }

    public static CustomerServiceImpl getService(){
        if(service == null) {
            service = new CustomerServiceImpl();
        }
        return service;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.create(customer);
    }

    @Override
    public Customer read(String id) {
        return repository.read(id);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.update(customer);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }
    @Override
    public Set<Customer> getAll() {
        return repository.getAll();
    }
}
