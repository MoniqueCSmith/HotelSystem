/**
 * CustomerQueryServiceImpl.java
 * Service class for the CustomerQueryImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.repository.ICustomerQueryRepository;
import za.ac.cput.service.CustomerQueryService;

import java.util.List;
import java.util.Set;
@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {
    private ICustomerQueryRepository repository;
@Autowired
    private CustomerQueryServiceImpl(ICustomerQueryRepository repository) { this.repository = repository; }

    @Override
    public CustomerQuery create(CustomerQuery customerQuery) {
        return this.repository.save(customerQuery);
    }

    @Override
    public CustomerQuery read(String queryID) {
        return this.repository.findById(queryID).orElse(null);
    }
    @Override
    public boolean delete(String queryID) {
        if (this.repository.existsById(queryID)) {
            this.repository.deleteById(queryID);
            return true;
        }
        return false;
    }
    @Override
    public List<CustomerQuery> getAll() {
    return this.repository.findAll();
    }
}
