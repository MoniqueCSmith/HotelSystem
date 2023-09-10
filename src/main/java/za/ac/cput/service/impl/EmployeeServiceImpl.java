package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private IEmployeeRepository repository;
    @Autowired
    private EmployeeServiceImpl(IEmployeeRepository repository){
        this.repository= repository;
    }
    @Override
    public Employee create(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee read(String EmployeeID) {
        return this.repository.findById(EmployeeID).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        if(this.repository.existsById(employee.getEmployeeID())){
            return this.repository.save(employee);
        }
        return null;
    }

    @Override
    public boolean delete(String EmployeeID) {
        if(this.repository.existsById(EmployeeID)){
            this.repository.deleteById(EmployeeID);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return this.repository.findAll();
    }
}
