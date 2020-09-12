package nl.ou.se.rest.sut.components.service.comment;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nl.ou.se.rest.sut.components.data.comment.dao.CommentService;
import nl.ou.se.rest.sut.components.data.comment.domain.Comment;
import nl.ou.se.rest.sut.components.service.comment.domain.CommentDto;
import nl.ou.se.rest.sut.components.service.comment.mapper.CommentMapper;

@RestController()
@RequestMapping("/rest/comments")
public class CommentController {

    // variable(s)
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentService commentService;

    // method(s)
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> findAll() {
        List<Comment> comments = commentService.findAll();
        return ResponseEntity.ok(CommentMapper.toDtos(comments));
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> create(@RequestParam Long id, @RequestParam String description) {
        CommentDto dto = new CommentDto();
        dto.setId(id);
        dto.setDescription(description);

        Comment comment = CommentMapper.toDomain(dto);

        comment = commentService.save(comment);
        return ResponseEntity.ok(CommentMapper.toDto(comment));
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> read(@PathVariable(name = "id") Long id) {
        Optional<Comment> comment = commentService.findById(id);

        if (!comment.isPresent()) {
            return ResponseEntity.badRequest().body(new CommentDto());
        }

        return ResponseEntity.ok(CommentMapper.toDto(comment.get()));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<?> update(@RequestParam Long id, @RequestParam String description) {
        CommentDto dto = new CommentDto();
        dto.setId(id);
        dto.setDescription(description);

        Comment comment = CommentMapper.toDomain(dto);

        comment = commentService.save(comment);
        return ResponseEntity.ok(CommentMapper.toDto(comment));
    }
    
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        Optional<Comment> comment = commentService.findById(id);

        if (!comment.isPresent()) {
            return ResponseEntity.badRequest().body(new CommentDto());
        }

        commentService.deleteById(id);
        return ResponseEntity.ok(CommentMapper.toDto(comment.get()));
    }
}