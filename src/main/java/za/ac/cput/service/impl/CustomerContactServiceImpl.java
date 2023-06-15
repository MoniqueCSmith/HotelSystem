/**
 * CustomerContactServiceImpl.java
 * Service class for the CustomerContactImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.repository.impl.CustomerContactRepositoryImpl;
import za.ac.cput.service.CustomerContactService;
import java.util.Set;
@Service
public class CustomerContactServiceImpl implements CustomerContactService {
    private static CustomerContactServiceImpl service = null;
    private CustomerContactRepositoryImpl repository = null;

    private CustomerContactServiceImpl() {
        if(repository == null) {
            repository = CustomerContactRepositoryImpl.getRepository();
        }
    }

    public static CustomerContactServiceImpl getService(){
        if(service == null) {
            service = new CustomerContactServiceImpl();
        }
        return service;
    }

    @Override
    public CustomerContact create(CustomerContact customerContact) {
        return repository.create(customerContact);
    }

    @Override
    public CustomerContact read(String id) {
        return repository.read(id);
    }

    @Override
    public CustomerContact update(CustomerContact customerContact) {
        return repository.update(customerContact);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }
    @Override
    public Set<CustomerContact> getAll() {
        return repository.getAll();
    }
}
