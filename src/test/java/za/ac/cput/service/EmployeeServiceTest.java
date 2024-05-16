package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    private final Contact contact = ContactFactory.buildContact("thato@gmail.com", "079 549 9283", "011 398 5555");
    private final Employee employee = EmployeeFactory.buildEmployee(222665093L, "Thato", "Mokoena", contact);

    @Test
    void a_create() {
        if (employee == null) throw new AssertionError();
        Employee created = employeeService.create(employee);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Employee read = employeeService.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Employee newEmployee = new Employee.Builder().copy(employee).setFirstName("Thato Bakoena").build();
        Employee updated = employeeService.update(newEmployee);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        System.out.println(employeeService.getAll());
    }
}