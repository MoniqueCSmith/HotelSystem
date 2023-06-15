/**
 * CustomerContactController.java
 * Controller class for CustomerContact
 * Author: Brandon Wise - 220049173
 * Date: 14 June 2023
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.factory.CustomerContactFactory;
import za.ac.cput.service.impl.CustomerContactServiceImpl;
import java.util.Set;

@RestController
@RequestMapping("/customerContact")
public class CustomerContactController {
    @Autowired
    private CustomerContactServiceImpl customerContactService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public CustomerContact create(@RequestBody CustomerContact customerContact){
        CustomerContact customerContactCreated = CustomerContactFactory.buildCustomerContact(customerContact.getCellNo(), customerContact.getEmail());
        return customerContactService.create(customerContactCreated);
    }
    @GetMapping("/read/{id}")
    public CustomerContact read(@PathVariable String id){
        return customerContactService.read(id);
    }

    @PostMapping("/update")
    public CustomerContact update(@RequestBody CustomerContact customerContact){
        return customerContactService.update(customerContact);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return customerContactService.delete(id);
    }

    @RequestMapping("/getall")
    public Set<CustomerContact> getall(){
        return customerContactService.getAll();
    }
}
