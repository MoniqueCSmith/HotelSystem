/**
 * MembershipService.java
 * Service interface for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.Membership;

import java.util.Set;

public interface MembershipService extends IService <Membership, String> {
    Set<Membership>getAll();
}
