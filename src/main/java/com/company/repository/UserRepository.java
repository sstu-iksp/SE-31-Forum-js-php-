package com.company.repository;

import com.company.model.User;

public interface UserRepository {
    Long saveUser(User user);
    User getById(Long userId);

    User getByLogin(String login);
}
