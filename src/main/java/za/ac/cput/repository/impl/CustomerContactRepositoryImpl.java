/**
 * CustomerContactRepository.java
 * Repository class for the CustomerContact
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository.impl;

import za.ac.cput.domain.CustomerContact;
import za.ac.cput.repository.ICustomerContactRepository;

import java.util.HashSet;
import java.util.Set;

public class CustomerContactRepositoryImpl implements ICustomerContactRepository {
    private static CustomerContactRepositoryImpl repository = null;
    private Set<CustomerContact> customerContactDB = null;

    private CustomerContactRepositoryImpl(){
        customerContactDB = new HashSet<CustomerContact>();
    }

    public static CustomerContactRepositoryImpl getRepository(){
        if(repository == null) {
            repository = new CustomerContactRepositoryImpl();
        }
        return repository;
    }
    @Override
     public CustomerContact create(CustomerContact customerContact) {
         boolean success = customerContactDB.add(customerContact);
         if(!success)
             return null;
         return customerContact;
     }
     @Override
     public CustomerContact read(String customerContactID) {
         for (CustomerContact c : customerContactDB) {
             if (c.getCustomerContactID().equals(customerContactID))
                 return c;
         }
         return null;
     }
     @Override
     public CustomerContact update(CustomerContact customerContact) {
         CustomerContact oldCustomerContact = read(customerContact.getCustomerContactID());
         if(oldCustomerContact != null){
             customerContactDB.remove(oldCustomerContact);
             customerContactDB.add(customerContact);
             return customerContact;
         }
         return null;
     }
     @Override
     public boolean delete(String customerContactID) {
         CustomerContact customerContactToDelete = read(customerContactID);
         if(customerContactToDelete == null)
             return false;
         customerContactDB.remove(customerContactToDelete);
         return true;
     }
    @Override
    public Set<CustomerContact> getAll() {
        return customerContactDB;
    }
}