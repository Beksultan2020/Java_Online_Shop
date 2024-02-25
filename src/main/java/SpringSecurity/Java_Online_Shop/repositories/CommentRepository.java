package SpringSecurity.Java_Online_Shop.repositories;

import SpringSecurity.Java_Online_Shop.modal.Comment;
import SpringSecurity.Java_Online_Shop.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Comment findByUser_Email(String email);

    List<Comment> findByProductId(Long productId);

}
