package SpringSecurity.Java_Online_Shop.dto;

import SpringSecurity.Java_Online_Shop.modal.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    private String comment;
    private Product product;
}
