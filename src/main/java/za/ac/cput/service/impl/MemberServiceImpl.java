/**
 * MemberServiceImpl.java
 * Service class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Member;
import za.ac.cput.repository.IMemberRepository;
import za.ac.cput.service.MemberService;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private IMemberRepository repository;

    @Autowired
    private MemberServiceImpl(IMemberRepository repository){
        this.repository = repository;
    }



    @Override
    public Member create(Member membership)
    {return repository.save(membership);
    }

    @Override
    public Member read(String memberId) {
        return this.repository.findById(memberId).orElse(null);
    }

    @Override
    public Member update(Member member) {
        if(this.repository.existsById(member.getMemberID())){
            return this.repository.save(member);
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
    public List<Member> getAll() {
        return this.repository.findAll();
    }

}