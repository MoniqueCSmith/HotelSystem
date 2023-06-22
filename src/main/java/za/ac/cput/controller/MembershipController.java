/**
 * MembershipController.java
 * Controller class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 14 June 2023
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Membership;
import za.ac.cput.util.factory.MembershipFactory;
import za.ac.cput.service.impl.MembershipServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    private MembershipServiceImpl membershipService;

    @PostMapping("/create")
    public Membership create(@RequestBody Membership membership){
        Membership membershipCreated = MembershipFactory.buildMembership(membership.getEmail(), membership.getPassword(), membership.getMembFirstName(), membership.getMembLastName(), membership.getPhoneNumber(), membership.getGender());
        return membershipService.create(membershipCreated);

    }

    @GetMapping("/read/{id}")
    public Membership read(@PathVariable String id){return membershipService.read(id);}

    @PostMapping("/update")
    public Membership update(@RequestBody Membership membership){
        return membershipService.update(membership);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return membershipService.delete(id);
    }

    @RequestMapping("/getall")
    public Set<Membership> getall(){
        return membershipService.getAll();
    }
}
