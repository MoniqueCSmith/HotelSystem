/**
 * ICustomerRepository.java
 * Interface Repository for the Customer
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;
@Repository
public interface IUserRepository extends JpaRepository<User, String> {
}
