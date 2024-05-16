package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long employeeNumber;
    protected String firstName;
    protected String lastName;

    @OneToOne
    protected Contact contact;

    protected Employee() {

    }

    private Employee(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getEmployeeNumber(), employee.getEmployeeNumber()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getContact(), employee.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeNumber(), getFirstName(), getLastName(), getContact());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {

        protected Long employeeNumber;
        protected String firstName;
        protected String lastName;
        protected Contact contact;

        public Builder setEmployeeNumber(Long employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(Employee e) {
            this.employeeNumber = e.getEmployeeNumber();
            this.firstName = e.getFirstName();
            this.lastName = e.getLastName();
            this.contact = e.getContact();
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
