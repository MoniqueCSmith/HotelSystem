/**
 * CustomerContactRepository.java
 * Repository class for the CustomerContact
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.CustomerContact;
import java.util.HashSet;
import java.util.Set;

public class CustomerContactRepository implements ICustomerContactRepository {
    private static CustomerContactRepository repository = null;
    private Set<CustomerContact> customerContactDB = null;

    private CustomerContactRepository(){
        customerContactDB = new HashSet<CustomerContact>();
    }

    public static CustomerContactRepository getRepository(){
        if(repository == null) {
            repository = new CustomerContactRepository();
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