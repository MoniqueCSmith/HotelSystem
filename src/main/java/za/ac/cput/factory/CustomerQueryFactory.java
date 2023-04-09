package za.ac.cput.factory;

import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.util.Helper;

public class CustomerQueryFactory {
    public static CustomerQuery buildCustomerQuery(String queryTitle, String queryEmail, String queryDescription){
        if(Helper.isNullOrEmpty(queryTitle) || Helper.isNullOrEmpty(queryEmail) || Helper.isNullOrEmpty(queryDescription)) {
            return null;
        }
        if(!Helper.isValidEmail(queryEmail)){
            return null;
        }

        String queryID = Helper.generateID();

        return new CustomerQuery.Builder()
                .setQueryID(queryID)
                .setQueryTitle(queryTitle)
                .setQueryEmail(queryEmail)
                .setQueryDescription(queryDescription)
                .build();
    }
}
