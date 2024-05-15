package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {

    public static Contact buildContact(String email, String mobilePhone, String workPhone){
        if(!Helper.IsValidEmailAddress(email) || Helper.IsValidPhoneNumber(mobilePhone) || Helper.IsValidPhoneNumber(workPhone))
            return null;

        return new Contact.Builder()
                    .setEmail(email)
                    .setMobilePhone(mobilePhone)
                    .setWorkPhone(workPhone)
                    .build();
    }
}
