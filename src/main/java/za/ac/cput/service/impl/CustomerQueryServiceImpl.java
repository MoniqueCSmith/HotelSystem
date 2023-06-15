/**
 * CustomerQueryServiceImpl.java
 * Service class for the CustomerQueryImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.repository.impl.CustomerQueryRepositoryImpl;
import za.ac.cput.service.CustomerQueryService;
import java.util.Set;
@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {
    private static CustomerQueryServiceImpl service = null;
    private CustomerQueryRepositoryImpl repository = null;

    private CustomerQueryServiceImpl() {
        if(repository == null) {
            repository = CustomerQueryRepositoryImpl.getRepository();
        }
    }

    public static CustomerQueryServiceImpl getService(){
        if(service == null) {
            service = new CustomerQueryServiceImpl();
        }
        return service;
    }

    @Override
    public CustomerQuery create(CustomerQuery customerQuery) {
        return repository.create(customerQuery);
    }

    @Override
    public CustomerQuery read(String id) {
        return repository.read(id);
    }
    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }
    @Override
    public Set<CustomerQuery> getAll() {
        return repository.getAll();
    }
}
