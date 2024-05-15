package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Contact {

    @Id
    private String email;
    private String mobilePhone;
    private String workPhone;

    protected Contact() {}

    private Contact(Builder builder){
        this.email = builder.email;
        this.mobilePhone = builder.mobilePhone;
        this.workPhone = builder.workPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getEmail(), contact.getEmail()) && Objects.equals(getMobilePhone(), contact.getMobilePhone()) && Objects.equals(getWorkPhone(), contact.getWorkPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getMobilePhone(), getWorkPhone());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                '}';
    }

    public static class Builder{
        private String email;
        private String mobilePhone;
        private String workPhone;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public Builder setWorkPhone(String workPhone) {
            this.workPhone = workPhone;
            return this;
        }

        public Builder copy(Contact c){
            this.email = c.email;
            this.mobilePhone = c.mobilePhone;
            this.workPhone = c.workPhone;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }
}
