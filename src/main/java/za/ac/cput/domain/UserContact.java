/**
 * UserContact.java
 * POJO class for the UserContact
 * Author: Brandon Wise - 220049173
 * Date: 5 April 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserContact implements Serializable {
    private String cellNo;
    private String email;
    protected UserContact() {
    }

    private UserContact(Builder builder){
        this.cellNo = builder.cellNo;
        this.email = builder.email;
    }
    public String getCellNo() {
        return cellNo;
    }
    public String getEmail() {
        return email;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserContact that = (UserContact) o;
        return Objects.equals(cellNo, that.cellNo) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellNo, email);
    }

    @Override
    public String toString() {
        return "UserContact{" +
                "cellNo='" + cellNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder{
        private String cellNo;
        private String email;

        public UserContact.Builder setCellNo(String cellNo) {
            this.cellNo = cellNo;
            return this;
        }
        public UserContact.Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public UserContact.Builder copy(UserContact userContact){
            this.cellNo = userContact.cellNo;
            this.email = userContact.email;
            return this;
        }
        public UserContact build(){
            return new UserContact(this);
        }
    }
}
