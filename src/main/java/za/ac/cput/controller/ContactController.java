package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PostMapping("/read/contact")
    public Contact read(@PathVariable String email){
        return contactService.read(email);
    }

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact){
        return contactService.update(contact);
    }

    @PostMapping("/getall")
    public List<Contact> getAll(){
        return contactService.getAll();
    }
}
