/**
 * CustomerContact.java
 * POJO class for the CustomerContact
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CustomerContact")
public class CustomerContact implements Serializable {
    @Id
    private String customerContactID;
    private String cellNo;
    private String email;

    public CustomerContact() {
    }

    private CustomerContact(Builder builder){
        this.customerContactID = builder.customerContactID;
        this.cellNo = builder.cellNo;
        this.email = builder.email;
    }
    public String getCustomerContactID() {
        return customerContactID;
    }
    public String getCellNo() {
        return cellNo;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerContact that = (CustomerContact) o;
        return Objects.equals(customerContactID, that.customerContactID) && Objects.equals(cellNo, that.cellNo) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerContactID, cellNo, email);
    }

    @Override
    public String toString() {
        return "CustomerContact{" +
                "customerContactID='" + customerContactID + '\'' +
                ", cellNo='" + cellNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder{
        private String customerContactID;
        private String cellNo;
        private String email;

        public CustomerContact.Builder setCustomerContactID(String customerContactID) {
            this.customerContactID = customerContactID;
            return this;
        }
        public CustomerContact.Builder setCellNo(String cellNo) {
            this.cellNo = cellNo;
            return this;
        }

        public CustomerContact.Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public CustomerContact.Builder copy(CustomerContact customerContact){
            this.customerContactID = customerContact.customerContactID;
            this.cellNo = customerContact.cellNo;
            this.email = customerContact.email;
            return this;
        }
        public CustomerContact build(){
            return new CustomerContact(this);
        }
    }
}
