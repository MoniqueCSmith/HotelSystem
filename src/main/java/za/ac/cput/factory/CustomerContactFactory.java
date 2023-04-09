package za.ac.cput.factory;

import za.ac.cput.domain.CustomerContact;
import za.ac.cput.util.Helper;

public class CustomerContactFactory {
    public static CustomerContact buildCustomerContact(String custPhoneNo, String custEmail) {
        if (Helper.isNullOrEmpty(custPhoneNo) || Helper.isNullOrEmpty(custEmail)) {
            return null;
        }
        if(!Helper.isValidEmail(custEmail)) {
            return null;
        }
        String custContactID = Helper.generateID();

        return new CustomerContact.Builder()
                .setCustContactID(custContactID)
                .setCustPhoneNo(custPhoneNo)
                .setCustEmail(custEmail)
                .build();
    }
}
