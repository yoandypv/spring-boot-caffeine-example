package com.yoandypv.cache.caffeine.service;

import com.yoandypv.cache.caffeine.config.CacheConfig;
import com.yoandypv.cache.caffeine.persistence.model.User;
import com.yoandypv.cache.caffeine.persistence.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = CacheConfig.USERS_INFO_CACHE, unless = "#result == null")
    public User findByUserName(String userName) {
        return this.userRepository.findByUserName(userName);
    }

}
