package com.summerpep.service;

import com.summerpep.model.User;
import com.summerpep.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public boolean checkUser(String username, String mail) {
        try {
            log.debug("Searching for the user with username: "+username);
            Optional<User>optionalUser= userRepository.findUserByUsername(username);
            log.debug("Searching for the user with mail: "+mail);
            Optional<User>optionalMail=userRepository.findUserByMail(mail);
            return optionalUser.isPresent()||optionalMail.isPresent();
        }
        catch (Exception e){
            log.error("couldn't find the user with mail: "+mail);
            return false;
        }
    }

    @Override
    @Transactional
    public User addUser(User user) {
        log.debug("trying to add user: "+user.getUsername());
        userRepository.save(user);
        return user;
    }

}
