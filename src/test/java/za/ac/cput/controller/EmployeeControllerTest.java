package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/payroll/employee";

    private static Employee employee;
    private static Contact contact;

    @BeforeAll
    public static void setup(){
        contact = ContactFactory.buildContact("thato@gmail.com", "079 549 9283", "011 398 5555");
        employee = EmployeeFactory.buildEmployee(222667087L, "Thato", "Mokoena", contact);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Employee> postEmployee = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postEmployee);
        assertNotNull(postEmployee.getBody());
        Employee employeeSaved = postEmployee.getBody();
        System.out.println("Employee: " + employeeSaved);

        ResponseEntity<Contact> postContact = restTemplate.postForEntity(url, contact, Contact.class);
        assertNotNull(postContact);
        assertNotNull(postContact.getBody());
        Contact contactSaved = postContact.getBody();
        System.out.println("Contact: " + contactSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read" + employee.getEmployeeNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Employee> postEmployee = restTemplate.postForEntity(url, employee, Employee.class);
        assertEquals(employee.getEmployeeNumber(), postEmployee.getBody().getEmployeeNumber());
        System.out.println("Read Employee: " + postEmployee.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update" + employee.getEmployeeNumber();
        Employee newEmployee = new Employee.Builder().copy(employee).setFirstName("Thato Bakoena").build();
        ResponseEntity<Employee> postEmployee = restTemplate.postForEntity(url, newEmployee, Employee.class);
        assertNotNull(postEmployee);
        assertNotNull(postEmployee.getBody());
        Employee employeeUpdated = postEmployee.getBody();
        assertEquals(newEmployee.getEmployeeNumber(), employeeUpdated.getEmployeeNumber());
        System.out.println("Update Employee: " + postEmployee.getBody());
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Long> entity = new HttpEntity<>(headers);
        ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.GET, entity, Long.class);
        System.out.println("Get All Employee: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}