/**
 * CustomerQueryServiceImpl.java
 * Service class for the CustomerQueryImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.repository.CustomerQueryRepository;
import za.ac.cput.service.CustomerQueryService;
import java.util.Set;

public class CustomerQueryServiceImpl implements CustomerQueryService {
    private static CustomerQueryServiceImpl service = null;
    private CustomerQueryRepository repository = null;

    private CustomerQueryServiceImpl() {
        if(repository == null) {
            repository = CustomerQueryRepository.getRepository();
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
    public CustomerQuery read(CustomerQuery id) {
        return repository.read(id.getQueryID());
    }
    @Override
    public boolean delete(CustomerQuery id) {
        return repository.delete(id.getQueryID());
    }
    @Override
    public Set<CustomerQuery> getAll() {
        return repository.getAll();
    }
}
