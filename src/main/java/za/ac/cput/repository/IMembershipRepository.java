/**
 * IMembershipRepository.java
 * Interface Repository class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Membership;

import java.util.Set;

@Repository
public interface IMembershipRepository extends JpaRepository<Membership, String> {

}
