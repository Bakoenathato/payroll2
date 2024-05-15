package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactServiceTest {

    @Autowired
    private ContactService contactService;
    private Contact contact = ContactFactory.buildContact("lannike@gmail.com", "079 549 9283", "011 398 5555");

    @Test
    void a_create() {
        Contact createdContact = contactService.create(contact);
        assertNotNull(createdContact);
        System.out.println(createdContact);
    }

    @Test
    void b_read() {
        Contact readContact = contactService.read(contact.getEmail());
        assertNotNull(readContact);
        System.out.println(readContact);
    }

    @Test
    void c_update() {
        Contact newContact = new Contact.Builder().copy(contact).setMobilePhone("076 328 2216").build();
        Contact updatedContact = contactService.update(newContact);
        assertNotNull(updatedContact);
        System.out.println(updatedContact);
    }

    @Test
    void d_getAll() {
        System.out.println(contactService.getAll());
    }
}