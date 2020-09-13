package nl.ou.se.rest.sut.components.data.comment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import nl.ou.se.rest.sut.components.data.comment.domain.Comment;

@Service
public class CommentService {

    // variable(s)
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Comment create(Comment comment) {
        jdbcTemplate.execute("INSERT INTO comments (description) values ('"+ comment.getDescription() +"');");
        Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
        comment.setId(id);

        return comment;
    }

    public Comment read(Long id) {
        Comment comment = jdbcTemplate.queryForObject("SELECT * FROM COMMENT WHERE ID = " + id + ";", Comment.class);
        return comment;
    }

    public Comment update(Comment comment) {
        jdbcTemplate.execute("UPDATE comments SET description = '"+ comment.getDescription() +"' WHERE id = " + comment.getId() +";");
        return comment;
    }

    public void delete(Long id) {
        jdbcTemplate.execute("DELETE FROM comments WHERE id = " + id +";");
    }
}