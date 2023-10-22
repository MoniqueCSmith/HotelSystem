package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test
    void createEmployee() {
        Employee employee= EmployeeFactory.createEmployee("James", "Reger", "Secratary", "0678901111", "James@gmail.com", "JamesR","09Yui", "Developer", false);
        assertNotNull(employee);
        System.out.println(employee);
        }
    }
