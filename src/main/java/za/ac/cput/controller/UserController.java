/**
 * UserController.java
 * Controller class for User
 * Author: Brandon Wise - 220049173
 * Date: 14 June 2023
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public User create(@RequestBody User user){
        User userCreated = UserFactory.buildUser(user.getFirstName(), user.getLastName(), user.getAddress(), user.getUserContact().getCellNo(), user.getUserContact().getEmail());
        return userService.create(userCreated);
    }
    @GetMapping("/read/{id}")
    public User read(@PathVariable String id){
        return userService.read(id);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return userService.delete(id);
    }

    @RequestMapping("/getall")
    public List<User> getall(){
        return userService.getAll();
    }

}
