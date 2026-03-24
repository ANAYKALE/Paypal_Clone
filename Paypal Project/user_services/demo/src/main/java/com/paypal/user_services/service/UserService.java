package com.paypal.user_services.service;

import com.paypal.user_services.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    Optional<User> getUserById(Long id);

    List<User> getAllUser();
}
