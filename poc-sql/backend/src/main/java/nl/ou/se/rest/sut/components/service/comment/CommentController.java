package nl.ou.se.rest.sut.components.service.comment;

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
    @Autowired
    private CommentService commentService;

    // method(s)
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> create(@RequestParam String description) {
        CommentDto dto = new CommentDto();
        dto.setDescription(description);

        Comment comment = CommentMapper.toDomain(dto);

        comment = commentService.create(comment);
        return ResponseEntity.ok(CommentMapper.toDto(comment));
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> read(@PathVariable(name = "id") Long id) {
        Comment comment = commentService.read(id);

        if (comment == null) {
            return ResponseEntity.badRequest().body(new CommentDto());
        }

        return ResponseEntity.ok(CommentMapper.toDto(comment));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<?> update(@RequestParam Long id, @RequestParam String description) {
        CommentDto dto = new CommentDto();
        dto.setId(id);
        dto.setDescription(description);

        Comment comment = CommentMapper.toDomain(dto);

        comment = commentService.update(comment);
        return ResponseEntity.ok(CommentMapper.toDto(comment));
    }
    
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        Comment comment = commentService.read(id);

        if (comment == null) {
            return ResponseEntity.badRequest().body(new CommentDto());
        }

        commentService.delete(id);
        return ResponseEntity.ok(CommentMapper.toDto(comment));
    }
}