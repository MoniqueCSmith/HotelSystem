/**
 * CustomerContactServiceImpl.java
 * Service class for the CustomerContactImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import za.ac.cput.domain.CustomerContact;
import za.ac.cput.repository.CustomerContactRepository;
import za.ac.cput.service.CustomerContactService;
import java.util.Set;

public class CustomerContactServiceImpl implements CustomerContactService {
    private static CustomerContactServiceImpl service = null;
    private CustomerContactRepository repository = null;

    private CustomerContactServiceImpl() {
        if(repository == null) {
            repository = CustomerContactRepository.getRepository();
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
    public CustomerContact read(CustomerContact id) {
        return repository.read(id.getCustomerContactID());
    }

    @Override
    public CustomerContact update(CustomerContact customerContact) {
        return repository.update(customerContact);
    }

    @Override
    public boolean delete(CustomerContact id) {
        return repository.delete(id.getCustomerContactID());
    }
    @Override
    public Set<CustomerContact> getAll() {
        return repository.getAll();
    }
}
