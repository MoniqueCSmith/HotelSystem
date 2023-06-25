/**
 * Customer.java
 * POJO class for the Customer
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
    @Id
    private String customerID;
    private String firstName;
    private String lastName;
    private String address;
    private boolean hasMembership;
    @Embedded
    private CustomerContact customerContact;

    protected Customer() {
    }

    private Customer(Builder builder){
        this.customerID = builder.customerID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.hasMembership = builder.hasMembership;
        //this.customerContact = builder.customerContact;
    }

    public String getCustomerID() {
        return customerID;
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

    public boolean HasMembership() {
        return hasMembership;
    }

    //public CustomerContact getCustomerContact() { return customerContact;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return hasMembership == customer.hasMembership && Objects.equals(customerID, customer.customerID) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(address, customer.address); //&& Objects.equals(customerContact, customer.customerContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, firstName, lastName, address, hasMembership); //, customerContact);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", hasMembership=" + hasMembership +
                '}';
    }

    public static class Builder{
        private String customerID;
        private String firstName;
        private String lastName;
        private String address;
        private  Boolean hasMembership;

        //private CustomerContact customerContact;

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
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

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setHasMembership(Boolean hasMembership) {
            this.hasMembership = hasMembership;
            return this;
        }
        //public Builder setCustomerContact(CustomerContact customerContact) {
            //this.customerContact = customerContact;
            //return this;
        //}
        public Builder copy(Customer customer){
            this.customerID = customer.customerID;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.address = customer.address;
            this.hasMembership = customer.hasMembership;
            //this.customerContact = customer.customerContact;
            return this;
        }
        public Customer build(){
            return new Customer(this);
        }
    }
}
