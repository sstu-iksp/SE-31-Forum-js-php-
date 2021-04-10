package com.company.repository;

import com.company.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Post> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM post",
                (resultSet, i) -> new Post(resultSet.getLong("id"), resultSet.getLong("author_id"), resultSet.getString("title"), resultSet.getString("text"))
        );
    }

    @Override
    public void save(Post post) {
        jdbcTemplate.update("INSERT INTO post (author_id, title, text) " +
                "VALUES (?, ?, ?)", post.getAuthorId(), post.getTitle(), post.getText());
    }
}
