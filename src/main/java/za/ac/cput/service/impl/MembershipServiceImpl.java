/**
 * MembershipServiceImpl.java
 * Service class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */

package za.ac.cput.service.impl;

import za.ac.cput.domain.Membership;
import za.ac.cput.repository.MembershipRepository;
import za.ac.cput.service.MembershipService;
import java.util.Set;

public class MembershipServiceImpl implements MembershipService {

    private static MembershipServiceImpl service = null;
    private MembershipRepository repository = null;

    private MembershipServiceImpl(){
        if(repository == null) {
            repository = MembershipRepository.getRepository();
        }
    }
    public static MembershipServiceImpl getService() {
        if (service == null) {
            service = new MembershipServiceImpl();
        }
        return service;
    }


    @Override
    public Membership create(Membership membership) {return repository.create(membership);
    }

    @Override
    public Membership read(String id) {
        return repository.read(id);
    }

    @Override
    public Membership update(Membership membership) {
        return repository.update(membership);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }
    @Override
    public Set<Membership> getAll() {
        return repository.getAll();
    }

}
