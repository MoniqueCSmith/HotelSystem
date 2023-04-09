/**
 * ICustomerContactRepository.java
 * Interface Repository for the CustomerContact
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.CustomerContact;
import java.util.Set;

public interface ICustomerContactRepository extends IRepository<CustomerContact, String>{
    Set<CustomerContact> getAll();
}
