/**
 * MemberController.java
 * Controller class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Member;
import za.ac.cput.factory.MemberFactory;
import za.ac.cput.service.impl.MemberServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @PostMapping("/create")
    public Member create(@RequestBody Member member){
        Member memberCreated = MemberFactory.buildMember(member.getUsername(), member.getPassword(), member.getUser().getFirstName(), member.getUser().getLastName(), member.getUser().getAddress(), member.getUser().getUserContact().getCellNo(), member.getUser().getUserContact().getEmail());
        return memberService.create(memberCreated);

    }

    @GetMapping("/read/{id}")
    public Member read(@PathVariable String id){return memberService.read(id);}

    @PostMapping("/update")
    public Member update(@RequestBody Member member){
        return memberService.update(member);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return memberService.delete(id);
    }

    @RequestMapping("/getall")
    public List<Member> getall(){
        return memberService.getAll();
    }
}
