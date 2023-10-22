package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.impl.EmployeeServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @CrossOrigin("http://localhost/8081")
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        Employee EmployeeCreated = EmployeeFactory.createEmployee(employee.getUser().getFirstName(), employee.getUser().getLastName(), employee.getUser().getAddress(), employee.getUser().getUserContact().getCellNo(), employee.getUser().getUserContact().getEmail() ,employee.getUsername(), employee.getPassword(),
                employee.getJobTitle(), employee.getAdmin());
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Employee employee) {
        Employee employeeLogin = employeeService.read(employee.getUsername());

            if (employeeLogin != null) {
                if (employeeLogin.getPassword().equals(employee.getPassword())) {
                    return ResponseEntity.ok("Login successful");
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }



