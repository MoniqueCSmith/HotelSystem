package za.ac.cput.factory;
import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

import static za.ac.cput.util.Helper.generateEmployeeID;


public class EmployeeFactory {

    public static Employee createEmployee(String Username, String Password, String JobTitle){

        String EmployeeID= generateEmployeeID();

        if(Helper.isNullOrEmpty(Username) || Helper.isNullOrEmpty(Password)|| Helper.isNullOrEmpty(JobTitle)){
            return null;
        }

        return new Employee.Builder()
                .setEmployeeID(EmployeeID)
                .setUsername(Username)
                .setPassword(Password)
                .setJobTitle(JobTitle)
                .build();
    }

}
