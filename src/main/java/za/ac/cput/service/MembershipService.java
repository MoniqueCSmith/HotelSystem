/**
 * MembershipService.java
 * Service interface for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.Membership;

import java.util.List;

public interface MembershipService extends IService <Membership, String> {
    List<Membership>getAll();
}