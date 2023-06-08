package za.ac.cput.factory;

import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.util.Helper;

public class CustomerQueryFactory {
    public static CustomerQuery buildCustomerQuery(String title, String email, String description){
        if(Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(description)) {
            return null;
        }
        if(!Helper.isValidEmail(email)){
            return null;
        }

        String queryID = Helper.generateID();

        return new CustomerQuery.Builder()
                .setQueryID(queryID)
                .setTitle(title)
                .setEmail(email)
                .setDescription(description)
                .build();
    }
}
