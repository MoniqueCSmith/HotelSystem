/**
 * IMemberRepository.java
 * Interface Repository class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Member;

@Repository
public interface IMemberRepository extends JpaRepository<Member, String> {

}
