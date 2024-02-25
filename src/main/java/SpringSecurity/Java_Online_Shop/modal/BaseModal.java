package SpringSecurity.Java_Online_Shop.modal;


import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BaseModal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
