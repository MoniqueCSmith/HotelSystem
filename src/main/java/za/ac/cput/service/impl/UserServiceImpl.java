/**
 * UserServiceImpl.java
 * Service class for the UserImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private IUserRepository repository;
@Autowired
    private UserServiceImpl(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
    return this.repository.save(user);
    }

    @Override
    public User read(String userID) {
    return this.repository.findById(userID).orElse(null);
    }

    @Override
    public User update(User user) {
        if(this.repository.existsById(user.getUserID()))
            return this.repository.save(user);
        return null;
    }

    @Override
    public boolean delete(String userID) {
        if (this.repository.existsById(userID)) {
            this.repository.deleteById(userID);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }
}
