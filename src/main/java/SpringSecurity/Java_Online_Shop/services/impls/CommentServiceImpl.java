package SpringSecurity.Java_Online_Shop.services.impls;

import SpringSecurity.Java_Online_Shop.dto.CommentDto;
import SpringSecurity.Java_Online_Shop.mapper.CommentMapper;
import SpringSecurity.Java_Online_Shop.modal.Comment;
import SpringSecurity.Java_Online_Shop.repositories.CommentRepository;
import SpringSecurity.Java_Online_Shop.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<CommentDto> listCommentsDto() {
        List<Comment> comments=commentRepository.findAll();
        return commentMapper.toDtoList(comments);
    }

    @Override
    public CommentDto getCommentDto(Long id) {
         Comment comment=commentRepository.findById(id).orElseThrow();
         if(comment!=null){
             return commentMapper.toDto(comment);
         }
         return null;
    }

    @Override
    public CommentDto addCommentDto(Comment comment) {
        Comment commentUser=commentRepository.findByUser_Email(comment.getUser().getEmail());
        if(commentUser!=null){
            Comment newComment=new Comment();
            newComment.setComment(comment.getComment());
            newComment.setUser(comment.getUser());
            newComment.setProduct(comment.getProduct());
            Comment saveComment=commentRepository.save(newComment);
            return commentMapper.toDto(saveComment);
        }
        return null;
    }

    @Override
    public CommentDto updateCommentDto(CommentDto commentDto) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
