package za.ac.cput.service;


import za.ac.cput.domain.Employee;

import java.util.List;

public interface EmployeeService extends IService<Employee, String>{

    List<Employee> getAll();
}
