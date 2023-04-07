package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();

    public static Customer create(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public static Customer read(String id) {
        return customers.stream()
                .filter(customer -> customer.getCustID().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static Customer update(Customer customer) {
        Customer oldCustomer = read(customer.getCustID());
        if (oldCustomer != null) {
            customers.remove(oldCustomer);
            customers.add(customer);
            return customer;
        }
        return null;
    }

    public static boolean delete(String id) {
        Customer customer = read(id);
        if (customer != null) {
            return customers.remove(customer);
        }
        return false;
    }

    public static List<Customer> getAll() {
        return customers;
    }
}
