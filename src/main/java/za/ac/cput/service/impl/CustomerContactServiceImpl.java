/**
 * CustomerContactServiceImpl.java
 * Service class for the CustomerContactImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.repository.ICustomerContactRepository;
import za.ac.cput.service.CustomerContactService;

import java.util.List;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {
    private ICustomerContactRepository repository;
@Autowired
    private CustomerContactServiceImpl(ICustomerContactRepository repository) { this.repository = repository;}

    @Override
    public CustomerContact create(CustomerContact customerContact) {
        return this.repository.save(customerContact);
    }

    @Override
    public CustomerContact read(String customerContactID) {
        return this.repository.findById(customerContactID).orElse(null);
    }

    @Override
    public CustomerContact update(CustomerContact customerContact) {
        if(this.repository.existsById(customerContact.getCustomerContactID()))
            return this.repository.save(customerContact);
        return null;
    }

    @Override
    public boolean delete(String customerContactID) {
        if (this.repository.existsById(customerContactID)) {
            this.repository.deleteById(customerContactID);
            return true;
        }
        return false;
    }
    @Override
    public List<CustomerContact> getAll() {
        return this.repository.findAll();
    }
}
