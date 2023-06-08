package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    public static Customer buildCustomer(String firstName, String lastName, String address, boolean hasMembership, CustomerContact customerContact){
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(address) || Helper.isNullOrEmpty(String.valueOf(hasMembership)) || Helper.isNullOrEmpty(String.valueOf(customerContact))){
            return null;
        }

        String customerID = Helper.generateID();

        return new Customer.Builder()
                .setCustomerID(customerID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setHasMembership(hasMembership)
                .setCustomerContact(customerContact)
                .build();
    }
}
