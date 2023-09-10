/**
 * Query.java
 * POJO class for the Query
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Query implements Serializable {
    @Id
    private String refNo;
    private String title;
    private String email;
    private String description;
    public static int nextId = 1;

    protected Query() {
    }

    private Query(Builder builder) {
        this.refNo = builder.refNo;
        this.title = builder.title;
        this.email = builder.email;
        this.description = builder.description;
    }
    public String getRefNo() {
        return refNo;
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
        Query that = (Query) o;
        return Objects.equals(refNo, that.refNo) && Objects.equals(title, that.title) && Objects.equals(email, that.email) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refNo, title, email, description);
    }

    @Override
    public String toString() {
        return "Query{" +
                "RefNo='" + refNo + '\'' +
                ", Title='" + title + '\'' +
                ", Email='" + email + '\'' +
                ", Description='" + description + '\'' +
                '}';
    }

    public static class Builder{
        private String refNo;
        private String title;
        private String email;
        private String description;

        public Query.Builder setRefNo(String refNo) {
            this.refNo = refNo;
            return this;
        }

        public Query.Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        public Query.Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Query.Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Query.Builder copy(Query query){
            this.refNo = query.refNo;
            this.title = query.title;
            this.email = query.email;
            this.description = query.description;
            return this;
        }
        public Query build(){
            return new Query(this);
        }
    }
}
