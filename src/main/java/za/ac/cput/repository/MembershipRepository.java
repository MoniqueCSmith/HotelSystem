package za.ac.cput.repository;

import za.ac.cput.domain.Membership;

import java.util.HashSet;
import java.util.Set;

public class MembershipRepository implements IMembershipRepository {

    private static MembershipRepository repository = null;
    private Set<Membership> membershipDB = null;
    private MembershipRepository(){
        membershipDB = new HashSet<Membership>();
    }
    public static MembershipRepository getRepository(){
        if(repository == null){
            repository = new MembershipRepository();
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
