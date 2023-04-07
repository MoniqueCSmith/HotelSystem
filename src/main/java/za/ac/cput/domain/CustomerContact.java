package za.ac.cput.domain;

public class CustomerContact {
    private String custPhoneNo;
    private String custEmail;

    private CustomerContact(Builder builder){
        this.custPhoneNo = builder.custPhoneNo;
        this.custEmail = builder.custEmail;
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
                "custPhoneNo=" + custPhoneNo +
                ", custEmail='" + custEmail + '\'' +
                '}';
    }

    public static class Builder{
        private String custPhoneNo;
        private String custEmail;

        public CustomerContact.Builder setCustPhoneNo(String custPhoneNo) {
            this.custPhoneNo = custPhoneNo;
            return this;
        }

        public CustomerContact.Builder setCustEmail(String custEmail) {
            this.custEmail = custEmail;
            return this;
        }
        public CustomerContact.Builder copy(CustomerContact customerContact){
            this.custPhoneNo = customerContact.custPhoneNo;
            this.custEmail = customerContact.custEmail;
            return this;
        }
        public CustomerContact build(){
            return new CustomerContact(this);
        }
    }
}
