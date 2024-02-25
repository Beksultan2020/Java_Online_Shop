package SpringSecurity.Java_Online_Shop.modal;


import jakarta.persistence.Entity;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Genre extends BaseModal{
    private String genreName;

}
