/**
 * CustomerService.java
 * Service class for the Customer
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.User;

import java.util.List;

public interface UserService extends IService <User, String>{
    List<User> getAll();
}
