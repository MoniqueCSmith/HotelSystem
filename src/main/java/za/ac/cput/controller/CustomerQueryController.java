/**
 * CustomerQueryController.java
 * Controller class for CustomerQuery
 * Author: Brandon Wise - 220049173
 * Date: 14 June 2023
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.util.factory.CustomerQueryFactory;
import za.ac.cput.service.impl.CustomerQueryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/customerQuery")
public class CustomerQueryController {
    @Autowired
    private CustomerQueryServiceImpl customerQueryService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public CustomerQuery create(@RequestBody CustomerQuery customerQuery){
        CustomerQuery customerQueryCreated = CustomerQueryFactory.buildCustomerQuery(customerQuery.getTitle(), customerQuery.getEmail(), customerQuery.getDescription());
        return customerQueryService.create(customerQueryCreated);
    }
    @GetMapping("/read/{id}")
    public CustomerQuery read(@PathVariable String id){
        return customerQueryService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return customerQueryService.delete(id);
    }

    @RequestMapping("/getall")
    public List<CustomerQuery> getall(){
        return customerQueryService.getAll();
    }
}
