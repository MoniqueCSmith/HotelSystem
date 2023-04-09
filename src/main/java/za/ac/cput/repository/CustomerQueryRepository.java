/**
 * CustomerQueryRepository.java
 * Repository class for the CustomerQuery
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.CustomerQuery;
import java.util.HashSet;
import java.util.Set;

public class CustomerQueryRepository implements ICustomerQueryRepository{
    private static CustomerQueryRepository repository = null;
    private Set<CustomerQuery> customerQueryDB = null;

    private CustomerQueryRepository(){
        customerQueryDB = new HashSet<CustomerQuery>();
    }

    public static CustomerQueryRepository getRepository(){
        if(repository == null) {
            repository = new CustomerQueryRepository();
        }
        return repository;

    }
    @Override
    public CustomerQuery create(CustomerQuery customerQuery) {
        boolean success = customerQueryDB.add(customerQuery);
        if(!success)
            return null;
        return customerQuery;
    }

    @Override
    public CustomerQuery read(String queryID) {
        for (CustomerQuery c : customerQueryDB) {
            if (c.getQueryID().equals(queryID))
                return c;
        }
        return null;
    }

    @Override
    public CustomerQuery update(CustomerQuery customerQuery) {
        CustomerQuery oldCustomerQuery = read(customerQuery.getQueryID());
        if(oldCustomerQuery != null){
            customerQueryDB.remove(oldCustomerQuery);
            customerQueryDB.add(customerQuery);
            return customerQuery;
        }
        return null;
    }

    @Override
    public boolean delete(String queryID) {
        CustomerQuery customerQueryToDelete = read(queryID);
        if(customerQueryToDelete == null)
            return false;
        customerQueryDB.remove(customerQueryToDelete);
        return true;
    }
    @Override
    public Set<CustomerQuery> getAll() {
        return customerQueryDB;
    }
}
