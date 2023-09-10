/**
 * ICustomerQueryRepository.java
 * Interface Repository for the CustomerQuery
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Query;

@Repository
public interface IQueryRepository extends JpaRepository<Query, String> {
}
