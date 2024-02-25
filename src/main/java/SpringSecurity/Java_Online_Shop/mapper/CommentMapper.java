package SpringSecurity.Java_Online_Shop.mapper;

import SpringSecurity.Java_Online_Shop.dto.CommentDto;
import SpringSecurity.Java_Online_Shop.modal.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto toDto(Comment comment);

    Comment toEntity(CommentDto commentDto);

    List<CommentDto> toDtoList(List<Comment> comment);

    List<Comment> toEntityList(List<CommentDto> commentDto);
}
