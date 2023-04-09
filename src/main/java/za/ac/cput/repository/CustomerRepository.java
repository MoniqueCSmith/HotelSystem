/**
 * CustomerRepository.java
 * Repository class for the Customer
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Customer;
import java.util.HashSet;
import java.util.Set;

public class CustomerRepository implements ICustomerRepository {
    private static CustomerRepository repository = null;
    private Set<Customer> customerDB = null;

    private CustomerRepository(){
        customerDB = new HashSet<Customer>();
    }

    public static CustomerRepository getRepository(){
        if(repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }
    @Override
    public Customer create(Customer customer) {
        boolean success = customerDB.add(customer);
        if(!success)
            return null;
        return customer;
    }

    @Override
    public Customer read(String custID) {
        for (Customer c : customerDB) {
            if (c.getCustID().equals(custID))
                return c;
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        Customer oldCustomer = read(customer.getCustID());
        if(oldCustomer != null){
            customerDB.remove(oldCustomer);
            customerDB.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String custID) {
        Customer customerToDelete = read(custID);
        if(customerToDelete == null)
            return false;
        customerDB.remove(customerToDelete);
        return true;
    }

    @Override
    public Set<Customer> getAll() {
        return customerDB;
    }
}
