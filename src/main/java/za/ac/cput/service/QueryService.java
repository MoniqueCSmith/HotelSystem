/**
 * CustomerQueryService.java
 * Service class for the CustomerQuery
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.Query;

import java.util.List;

public interface QueryService {
    Query create(Query query);
    Query read(String id);
    boolean delete(String id);
    List<Query> getAll();
}
