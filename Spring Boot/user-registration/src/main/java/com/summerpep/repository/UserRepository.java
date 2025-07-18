package com.summerpep.repository;

import com.summerpep.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.mail= :mail")
    Optional<User> findUserByMail(String mail);

    @Query("select u from User u where u.username= :username")
    Optional<User> findUserByUsername(String username);
}
