/**
 * QueryFactory.java
 * Factory class for the Query
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Query;
import za.ac.cput.util.Helper;


public class QueryFactory {
    public static Query buildQuery(String title, String email, String description){
        String refNo = Helper.generateQueryID();

        if(Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(description)) {
            return null;
        }
        if(!Helper.isValidEmail(email)){
            return null;
        }
        if(title.length() > 100){
            return null;
        }
        if(description.length() > 1000){
            return null;
        }



        return new Query.Builder()
                .setRefNo(refNo)
                .setTitle(title)
                .setEmail(email)
                .setDescription(description)
                .build();
    }
}
