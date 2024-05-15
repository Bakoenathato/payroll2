package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeFactoryTest {

    private Employee employee;
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = ContactFactory.buildContact("thatobakoena@gmail.com", "076 326 2216", "2055550125");
    }

    @Test
    void a_testCreateEmployee() {
        employee = EmployeeFactory.buildEmployee(222667087L, "Thato", "Mokoena", contact);
        assertNotNull(employee);
        System.out.println(employee.toString());
    }

}