package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl service;
    private static Employee employee= EmployeeFactory.createEmployee("Stephan", "Steve", "89 Nassua Street Bothasig", "0932394308", "Linked@gmail.com", "JSteve", "098jke", "Secratary", false);
    @Test
    void a_create() {
        Employee created = service.create(employee);
        assertEquals(employee.getEmployeeID(), created.getEmployeeID());
        System.out.println("This has been created: " + created);
    }

    @Test
    void b_read() {
        Employee read= service.read(employee.getEmployeeID());
        assertNotNull(read);
        System.out.println("This has been read: " + read);
    }

    @Test
    void c_update() {
        Employee newEmployee= new Employee.Builder().copy(employee)
                .setPassword("120823KL")
                .build();
        Employee updated= service.update(newEmployee);
        assertEquals(newEmployee.getPassword(), updated.getPassword());
        System.out.println("This has been updated" + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success= service.delete(employee.getEmployeeID());
        assertTrue(success);
        System.out.println("Files have been deleted." + success);
    }

    @Test
    void e_getAll() {
        System.out.println("This is what has been fetched:");
        System.out.println(service.getAll());
    }
}
