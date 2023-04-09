package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    public static Customer buildCustomer(String custFirstName, String custLastName, String custAddress, boolean hasMembership, CustomerContact customerContact){
        if(Helper.isNullOrEmpty(custFirstName) || Helper.isNullOrEmpty(custLastName) || Helper.isNullOrEmpty(custAddress) || Helper.isNullOrEmpty(String.valueOf(hasMembership)) || Helper.isNullOrEmpty(String.valueOf(customerContact))){
            return null;
        }

        String custID = Helper.generateID();

        return new Customer.Builder()
                .setCustID(custID)
                .setCustFirstName(custFirstName)
                .setCustLastName(custLastName)
                .setCustAddress(custAddress)
                .setHasMembership(hasMembership)
                .setCustomerContact(customerContact)
                .build();
    }
}
