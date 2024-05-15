package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactFactoryTest {

    private Contact contact;

    @Test
    void a_createContact() {
        contact = ContactFactory.buildContact("thatobakoena@gmail.com", "076 326 2216", "205 555 0125");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void b_createContactWithEmailFail() {
        contact = ContactFactory.buildContact("ThatoBakoena.gmail@com", "076 326 2216", "2055550125");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void c_createContactWithEmailFail() {
        contact = ContactFactory.buildContact("", "076 326 2216", "2055550125");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void d_createContactWitMobileFail() {
        contact = ContactFactory.buildContact("thatobakoena@gmail.com", "076 328 22216", "2055550125");
        assertNotNull(contact);
        System.out.println(contact);
    }
}