package nl.ou.se.rest.sut.components.service.comment.mapper;

import org.springframework.beans.BeanUtils;

import nl.ou.se.rest.sut.components.data.comment.domain.Comment;
import nl.ou.se.rest.sut.components.service.comment.domain.CommentDto;

public class CommentMapper {

    // method(s)
    public static CommentDto toDto(Comment comment) {
        CommentDto dto = new CommentDto();
        BeanUtils.copyProperties(comment, dto);
        return dto;
    }

    public static Comment toDomain(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        return comment;
    }
}