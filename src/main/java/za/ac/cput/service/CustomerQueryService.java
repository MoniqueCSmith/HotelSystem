/**
 * CustomerQueryService.java
 * Service class for the CustomerQuery
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.CustomerQuery;

import java.util.List;
import java.util.Set;

public interface CustomerQueryService {
    CustomerQuery create(CustomerQuery customerQuery);
    CustomerQuery read(String id);
    boolean delete(String id);
    List<CustomerQuery> getAll();
}
