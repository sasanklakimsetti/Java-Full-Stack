package com.summerpep.todo.service;

import com.summerpep.todo.model.User;
import com.summerpep.todo.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final Logger log= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;
    @Override
    public User findUsername(String username) {
        log.debug("findByUsername called searching for "+username);
        try{
            Optional<User>optional=userRepository.findById(username);
            // if there is not element, throw NoSuchElementException
            return optional.orElse(null);  // if found return user, else null
        }
        catch (Exception e){
            log.error(username+" was not found");
            return null;
        }
    }

    @Override
    @Transactional
    public User addUser(User user) {
        log.debug("trying to add user "+user.getUsername());
        userRepository.save(user);
        return user;
    }
}
