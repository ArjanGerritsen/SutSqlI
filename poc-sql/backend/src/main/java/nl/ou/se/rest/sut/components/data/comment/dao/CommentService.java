package nl.ou.se.rest.sut.components.data.comment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import nl.ou.se.rest.sut.components.data.comment.domain.Comment;

@Component
public class CommentService {

    // variables
    private JdbcTemplate jdbcTemplate;
    
    public CommentService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Comment> findAll() {
        return new ArrayList<Comment>();
        // TODO return jdbcTemplate.queryForObject("SELECT * FROM comments;", new Object[] { id }, new CommentMapper());
    }

    public Optional<Comment> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Comment save(Comment comment) {
        // TODO Auto-generated method stub
        return null;
    }

    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }
}