/**
 * CustomerContactService.java
 * Service class for the CustomerContact
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.CustomerContact;

import java.util.List;

public interface CustomerContactService extends IService <CustomerContact, String>{
    List<CustomerContact> getAll();
}
