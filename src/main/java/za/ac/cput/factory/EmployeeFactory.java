package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {

    public static Employee buildEmployee(Long employeeNumber, String firstName, String lastName, Contact contact) {
        if (Helper.isNullOrEmpty(String.valueOf(employeeNumber)) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || contact == null)
            return null;

        return new Employee.Builder().setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .build();
    }

    public static Employee buildEmployee(String firstName, String lastName, String email, String mobilePhone, String workPhone) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) )
            return null;

        if (Helper.IsValidEmailAddress(email) || Helper.IsValidPhoneNumber(mobilePhone) || Helper.IsValidPhoneNumber(workPhone))
            return null;

        Long employeeNumber = null;
        Contact contact = ContactFactory.buildContact(email, mobilePhone, workPhone);

        return new Employee.Builder().setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .build();
    }
}
