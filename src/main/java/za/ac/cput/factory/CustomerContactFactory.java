package za.ac.cput.factory;

import za.ac.cput.domain.CustomerContact;
import za.ac.cput.util.Helper;

public class CustomerContactFactory {
    public static CustomerContact buildCustomerContact(String cellNo, String email) {
        if (Helper.isNullOrEmpty(cellNo) || Helper.isNullOrEmpty(email)) {
            return null;
        }
        if(!Helper.isValidEmail(email)) {
            return null;
        }
        String customerContactID = Helper.generateID();

        return new CustomerContact.Builder()
                .setCustomerContactID(customerContactID)
                .setCellNo(cellNo)
                .setEmail(email)
                .build();
    }
}
