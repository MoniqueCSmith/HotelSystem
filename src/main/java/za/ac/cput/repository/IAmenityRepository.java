/**
 * IAmenityRepository.java
 * Interface Repository for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Amenity;
@Repository
public interface IAmenityRepository extends JpaRepository<Amenity, String> {
}
