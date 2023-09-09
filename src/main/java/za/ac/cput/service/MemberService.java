/**
 * MemberService.java
 * Service interface for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.Member;

import java.util.List;

public interface MemberService extends IService <Member, String> {
    List<Member>getAll();
}