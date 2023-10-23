package za.ac.cput.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable{

    @Id
    private String EmployeeID;
    @Embedded
    private User user;
    private String Username;
    private String Password;
    private String JobTitle;
    private Boolean isAdmin;
    public static int nextEmployeeID = 1;
    protected Employee(){}

    private Employee(Builder builder){

        this.EmployeeID= builder.EmployeeID;
        this.user= builder.user;
        this.Username= builder.Username;
        this.Password= builder.Password;
        this.JobTitle= builder.JobTitle;
        this.isAdmin= builder.isAdmin;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }



    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(EmployeeID, employee.EmployeeID) && Objects.equals(user, employee.user) && Objects.equals(Username, employee.Username) && Objects.equals(Password, employee.Password) && Objects.equals(JobTitle, employee.JobTitle) && Objects.equals(isAdmin, employee.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EmployeeID, user, Username, Password, JobTitle, isAdmin);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID='" + EmployeeID + '\'' +
                ", user=" + user +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public static class Builder{

        private String EmployeeID;
        private User user;
        private String Username;
        private String Password;
        private String JobTitle;
        private Boolean isAdmin;

        public Builder setEmployeeID(String employeeID) {
            EmployeeID = employeeID;
            return this;
        }

        public Builder setUsername(String username) {
            Username = username;
            return this;
        }

        public Builder setPassword(String password) {
            Password = password;
            return this;
        }

        public Builder setJobTitle(String jobTitle) {
            JobTitle = jobTitle;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setAdmin(Boolean admin) {
            isAdmin = admin;
            return this;
        }

        public Builder copy(Employee employee){
            this.EmployeeID= employee.EmployeeID;
            this.user= employee.user;
            this.Username= employee.Username;
            this.Password = employee.Password;
            this.JobTitle= employee.JobTitle;
            this.isAdmin= employee.isAdmin;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }

    }

}
