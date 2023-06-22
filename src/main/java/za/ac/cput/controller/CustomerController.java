/**
 * CustomerController.java
 * Controller class for Customer
 * Author: Brandon Wise - 220049173
 * Date: 14 June 2023
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.factory.CustomerFactory;
import za.ac.cput.service.impl.CustomerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        Customer customerCreated = CustomerFactory.buildCustomer(customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.HasMembership(), customer.getCustomerContact());
        return customerService.create(customerCreated);
    }
    @GetMapping("/read/{id}")
    public Customer read(@PathVariable String id){
        return customerService.read(id);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer){
        return customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return customerService.delete(id);
    }

    @RequestMapping("/getall")
    public List<Customer> getall(){
        return customerService.getAll();
    }

}
