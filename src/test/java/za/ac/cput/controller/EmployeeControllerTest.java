package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/payroll/employee";

    private Employee employee;
    private Contact contact;

    @BeforeAll
    public void setup(){
        contact = ContactFactory.buildContact("lannike@gmail.com", "079 549 9283", "011 398 5555");
        employee = EmployeeFactory.buildEmployee(222667087L, "Thato", "Mokoena", contact);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Employee> postEmployee = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postEmployee);
        ResponseEntity<Contact> postContact = restTemplate.postForEntity(url, contact, Contact.class);
        assertNotNull(postContact);
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }
}