/**
 * IMembershipRepository.java
 * Interface Repository class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Membership;

import java.util.Set;

public interface IMembershipRepository extends IRepository<Membership, String> {

    public Set<Membership> getAll();
}
