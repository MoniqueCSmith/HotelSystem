package za.ac.cput.domain;

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
private String Username;
private String Password;
private String JobTitle;

    public static int nextEmployeeID = 1;
protected Employee(){}

    private Employee(Builder builder){

    this.EmployeeID= builder.EmployeeID;
    this.Username= builder.Username;
    this.Password= builder.Password;
    this.JobTitle= builder.JobTitle;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(EmployeeID, employee.EmployeeID) && Objects.equals(Username, employee.Username) && Objects.equals(Password, employee.Password) && Objects.equals(JobTitle, employee.JobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), EmployeeID, Username, Password, JobTitle);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID='" + EmployeeID + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                '}';
    }

    public static class Builder{

        private String EmployeeID;
        private String Username;
        private String Password;
        private String JobTitle;

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

        public Builder copy(Employee employee){
            this.EmployeeID= employee.EmployeeID;
            this.Username= employee.Username;
            this.Password = employee.Password;
            this.JobTitle= employee.JobTitle;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }

    }

}
