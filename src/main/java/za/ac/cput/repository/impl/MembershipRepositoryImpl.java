/**
 * MembershipRepository.java
 * Repository class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.repository.impl;

import za.ac.cput.domain.Membership;
import za.ac.cput.repository.IMembershipRepository;

import java.util.HashSet;
import java.util.Set;

public class MembershipRepositoryImpl implements IMembershipRepository {

    private static MembershipRepositoryImpl repository = null;
    private Set<Membership> membershipDB = null;
    private MembershipRepositoryImpl(){
        membershipDB = new HashSet<Membership>();
    }
    public static MembershipRepositoryImpl getRepository(){
        if(repository == null){
            repository = new MembershipRepositoryImpl();
        }
        return repository;
    }


    @Override
    public Membership create(Membership membership) {
        boolean success = membershipDB.add(membership);
        if(!success)
            return null;
        return membership;
    }

    @Override
    public Membership read(String membershipID) {
        for (Membership a : membershipDB){
            if (a.getMemberID().equals(membershipID))
                return a;
        }
        return null;
    }

    @Override
    public Membership update(Membership membership) {
        Membership oldMembership = read(membership.getMemberID());
        if(oldMembership != null){
            membershipDB.remove(oldMembership);
            membershipDB.add(membership);
            return membership;
        }
        return null;
    }

    @Override
    public boolean delete(String memberID) {
        Membership membershipToDelete = read(memberID);
        if(membershipToDelete == null)
            return false;
        membershipDB.remove(membershipToDelete);
        return true;
    }
    @Override
    public Set<Membership> getAll() {
        return membershipDB;
    }

}
