package SpringSecurity.Java_Online_Shop.services;

import SpringSecurity.Java_Online_Shop.dto.CommentDto;
import SpringSecurity.Java_Online_Shop.modal.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDto> listCommentsDto();

    CommentDto getCommentDto(Long id);

    CommentDto addCommentDto(Comment comment);

    CommentDto updateCommentDto(CommentDto commentDto);

    void deleteComment(Long id);
}
