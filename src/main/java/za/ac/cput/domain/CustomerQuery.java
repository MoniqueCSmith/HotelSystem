/**
 * CustomerQuery.java
 * POJO class for the CustomerQuery
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.domain;

public class CustomerQuery {
    private String queryID;
    private String queryTitle;
    private String queryEmail;
    private String queryDescription;
    private CustomerQuery(Builder builder) {
        this.queryID = builder.queryID;
        this.queryTitle = builder.queryTitle;
        this.queryEmail = builder.queryEmail;
        this.queryDescription = builder.queryDescription;
    }
    public String getQueryID() {
        return queryID;
    }

    public String getQueryTitle() {
        return queryTitle;
    }

    public String getQueryEmail() {
        return queryEmail;
    }

    public String getQueryDescription() {
        return queryDescription;
    }

    @Override
    public String toString() {
        return "CustomerQuery{" +
                "queryID='" + queryID + '\'' +
                ", queryTitle='" + queryTitle + '\'' +
                ", queryEmail='" + queryEmail + '\'' +
                ", queryDescription='" + queryDescription + '\'' +
                '}';
    }

    public static class Builder{
        private String queryID;
        private String queryTitle;
        private String queryEmail;
        private String queryDescription;

        public CustomerQuery.Builder setQueryID(String queryID) {
            this.queryID = queryID;
            return this;
        }

        public CustomerQuery.Builder setQueryTitle(String queryTitle) {
            this.queryTitle = queryTitle;
            return this;
        }
        public CustomerQuery.Builder setQueryEmail(String queryEmail) {
            this.queryEmail = queryEmail;
            return this;
        }
        public CustomerQuery.Builder setQueryDescription(String queryDescription) {
            this.queryDescription = queryDescription;
            return this;
        }
        public CustomerQuery.Builder copy(CustomerQuery customerQuery){
            this.queryID = customerQuery.queryID;
            this.queryTitle = customerQuery.queryTitle;
            this.queryEmail = customerQuery.queryEmail;
            this.queryDescription = customerQuery.queryDescription;
            return this;
        }
        public CustomerQuery build(){
            return new CustomerQuery(this);
        }
    }
}
