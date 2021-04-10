package com.company.repository;

import com.company.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long saveUser(User user) {
        return jdbcTemplate.query("INSERT INTO \"user\" (login, first_name, last_name, password, email, telegram, avatar_url, \"group\") " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING id", (resultSet, i) -> resultSet.getLong(1),
                user.getLogin(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getTelegram(),
                user.getAvatarUrl(), user.getGroup()).get(0);
    }

    @Override
    public User getById(Long userId) {
        List<User> result = jdbcTemplate.query("SELECT * FROM \"user\" WHERE id = ?", (resultSet, i) ->
                new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("telegram"),
                        resultSet.getString("avatar_url"),
                        resultSet.getString("group")
                ), userId);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public User getByLogin(String login) {
        List<User> result = jdbcTemplate.query("SELECT * FROM \"user\" WHERE login = ?", (resultSet, i) ->
                new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("telegram"),
                        resultSet.getString("avatar_url"),
                        resultSet.getString("group")
                ), login);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
