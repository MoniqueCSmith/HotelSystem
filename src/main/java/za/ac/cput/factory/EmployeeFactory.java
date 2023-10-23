package za.ac.cput.factory;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import static za.ac.cput.util.Helper.generateEmployeeID;

public class EmployeeFactory {

    public static Employee createEmployee(String firstName, String lastName, String address, String cellNo, String email,
                                          String Username, String Password, String JobTitle, Boolean isAdmin){

        String EmployeeID= generateEmployeeID();

        if(Helper.isNullOrEmpty(Username) || Helper.isNullOrEmpty(Password) ||Helper.isNullOrEmpty(JobTitle)){
            return null;
        }

        User user = UserFactory.buildUser(firstName, lastName, address, cellNo, email);

        return new Employee.Builder()
                .setEmployeeID(EmployeeID)
                .setUser(user)
                .setUsername(Username)
                .setPassword(Password)
                .setJobTitle(JobTitle)
                .setAdmin(isAdmin)
                .build();
    }


}
