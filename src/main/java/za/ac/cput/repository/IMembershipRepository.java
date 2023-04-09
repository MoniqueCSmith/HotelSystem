package za.ac.cput.repository;

import za.ac.cput.domain.Membership;

import java.util.Set;

public interface IMembershipRepository extends IRepository<Membership, String> {

    public Set<Membership> getAll();
}
