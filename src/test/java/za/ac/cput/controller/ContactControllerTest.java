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
class ContactControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/payroll/contact";

    private static Contact contact;

    @BeforeAll
    public static void setup(){
        contact = ContactFactory.buildContact("thato@gmail.com", "079 549 9283", "011 398 5555");
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, contact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Contact createdContact = postResponse.getBody();
        assertEquals(contact.getEmail(), createdContact.getEmail());
        System.out.println("Created contact: " + createdContact);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + contact.getEmail();
        System.out.println("URL: " + url);
        ResponseEntity<Contact> postResponse = restTemplate.getForEntity(url, Contact.class);
        assertEquals(contact.getEmail(), postResponse.getBody().getEmail());
        System.out.println("Read contact: " + postResponse.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Contact newContact = new Contact.Builder().copy(contact).setMobilePhone("076 328 2216").build();
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, newContact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Contact updatedContact = postResponse.getBody();
        assertEquals(contact.getEmail(), updatedContact.getEmail());
        System.out.println("Updated contact: " + updatedContact);
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Get All Contact: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}