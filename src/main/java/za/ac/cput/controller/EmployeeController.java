package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        Employee EmployeeCreated = EmployeeFactory.createEmployee(employee.getUsername(), employee.getPassword(),
                employee.getJobTitle());
        return employeeService.create(EmployeeCreated);
    }

    @GetMapping("/read/{id}")
    public Employee read(@PathVariable String id){
        return employeeService.read(id);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return employeeService.delete(id);
    }

    @GetMapping("/getall")
    public List<Employee> getall(){
        return employeeService.getAll();
    }

}
