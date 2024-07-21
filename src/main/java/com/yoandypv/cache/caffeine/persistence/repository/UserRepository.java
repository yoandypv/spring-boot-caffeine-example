package com.yoandypv.cache.caffeine.persistence.repository;

import com.yoandypv.cache.caffeine.persistence.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class UserRepository implements InitializingBean {

    private Map<String, User> userDB;

    public User findByUserName(String userName) {
       log.info("Called repository for username={}", userName);
       return Optional
               .ofNullable(userDB.get(userName))
               .orElseThrow( () -> new RuntimeException("User not found") );

    }

    @Override
    public void afterPropertiesSet() {
        userDB = new HashMap<>();
        userDB.put("pulga",  User.newUser("pulga", "Messi"));
        userDB.put("dibu",  User.newUser("dibu", "Emiliano"));
        userDB.put("fideo",  User.newUser("fideo", "Angel"));
        userDB.put("araña",  User.newUser("araña", "Julian"));
        userDB.put("cuti",  User.newUser("cuti", "Cristian"));
        userDB.put("huevo",  User.newUser("huevo", "Marcos"));
        userDB.put("joya",  null);
    }
}
