/**
 * User.java
 * POJO class for the User
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String address;
    @Embedded
    private UserContact userContact;


    protected User() {
    }

    private User(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.userContact = builder.userContact;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public UserContact getUserContact() { return userContact;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(address, user.address) && Objects.equals(userContact, user.userContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, userContact);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", userContact=" + userContact +
                '}';
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String address;
        private UserContact userContact;


        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setUserContact(UserContact userContact) {
            this.userContact = userContact;
            return this;
        }
        public Builder copy(User user){
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.address = user.address;
            this.userContact = user.userContact;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
