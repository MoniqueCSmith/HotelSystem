/**
 * ICustomerQueryRepository.java
 * Interface Repository for the CustomerQuery
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.CustomerQuery;
import java.util.Set;

public interface ICustomerQueryRepository extends IRepository<CustomerQuery, String>{
    Set<CustomerQuery> getAll();
}
