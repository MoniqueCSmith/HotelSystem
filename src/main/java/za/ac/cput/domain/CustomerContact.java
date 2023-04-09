/**
 * CustomerContact.java
 * POJO class for the CustomerContact
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.domain;

public class CustomerContact {
    private String custContactID;
    private String custPhoneNo;
    private String custEmail;

    private CustomerContact(Builder builder){
        this.custContactID = builder.custContactID;
        this.custPhoneNo = builder.custPhoneNo;
        this.custEmail = builder.custEmail;
    }
    public String getCustContactID() {
        return custContactID;
    }
    public String getCustPhoneNo() {
        return custPhoneNo;
    }
    public String getCustEmail() {
        return custEmail;
    }

    @Override
    public String toString() {
        return "CustomerContact{" +
                "custContactID='" + custContactID + '\'' +
                ", custPhoneNo='" + custPhoneNo + '\'' +
                ", custEmail='" + custEmail + '\'' +
                '}';
    }

    public static class Builder{
        private String custContactID;
        private String custPhoneNo;
        private String custEmail;

        public CustomerContact.Builder setCustContactID(String custContactID) {
            this.custContactID = custContactID;
            return this;
        }
        public CustomerContact.Builder setCustPhoneNo(String custPhoneNo) {
            this.custPhoneNo = custPhoneNo;
            return this;
        }

        public CustomerContact.Builder setCustEmail(String custEmail) {
            this.custEmail = custEmail;
            return this;
        }
        public CustomerContact.Builder copy(CustomerContact customerContact){
            this.custContactID = customerContact.custContactID;
            this.custPhoneNo = customerContact.custPhoneNo;
            this.custEmail = customerContact.custEmail;
            return this;
        }
        public CustomerContact build(){
            return new CustomerContact(this);
        }
    }
}
