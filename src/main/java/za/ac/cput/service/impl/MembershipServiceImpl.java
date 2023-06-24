/**
 * MembershipServiceImpl.java
 * Service class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Membership;
import za.ac.cput.repository.IMembershipRepository;
import za.ac.cput.service.MembershipService;
import java.util.List;
import java.util.Set;

@Service
public class MembershipServiceImpl implements MembershipService {

    private IMembershipRepository repository;

    @Autowired
    private MembershipServiceImpl(IMembershipRepository repository){
        this.repository = repository;
    }



    @Override
    public Membership create(Membership membership)
    {return repository.save(membership);
    }

    @Override
    public Membership read(String memberId) {
        return this.repository.findById(memberId).orElse(null);
    }

    @Override
    public Membership update(Membership membership) {
        if(this.repository.existsById(membership.getMemberID())){
            return this.repository.save(membership);
        }
        return null;
    }

    @Override
    public boolean delete(String memberId) {
        if(this.repository.existsById(memberId)){
            this.repository.deleteById(memberId);
            return true;
        }
        return false;
    }

    @Override
    public List<Membership> getAll() {
        return this.repository.findAll();
    }

}