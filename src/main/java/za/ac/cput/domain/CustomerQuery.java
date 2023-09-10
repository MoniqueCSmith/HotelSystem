/**
 * CustomerQuery.java
 * POJO class for the CustomerQuery
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CustomerQuery")
public class CustomerQuery implements Serializable {
    @Id
    private String queryID;
    private String title;
    private String email;
    private String description;

    protected CustomerQuery() {
    }

    private CustomerQuery(Builder builder) {
        this.queryID = builder.queryID;
        this.title = builder.title;
        this.email = builder.email;
        this.description = builder.description;
    }
    public String getQueryID() {
        return queryID;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerQuery that = (CustomerQuery) o;
        return Objects.equals(queryID, that.queryID) && Objects.equals(title, that.title) && Objects.equals(email, that.email) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryID, title, email, description);
    }

    @Override
    public String toString() {
        return "CustomerQuery{" +
                "queryID='" + queryID + '\'' +
                ", Title='" + title + '\'' +
                ", Email='" + email + '\'' +
                ", Description='" + description + '\'' +
                '}';
    }

    public static class Builder{
        private String queryID;
        private String title;
        private String email;
        private String description;

        public CustomerQuery.Builder setQueryID(String queryID) {
            this.queryID = queryID;
            return this;
        }

        public CustomerQuery.Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        public CustomerQuery.Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public CustomerQuery.Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public CustomerQuery.Builder copy(CustomerQuery customerQuery){
            this.queryID = customerQuery.queryID;
            this.title = customerQuery.title;
            this.email = customerQuery.email;
            this.description = customerQuery.description;
            return this;
        }
        public CustomerQuery build(){
            return new CustomerQuery(this);
        }
    }
}
