package SpringSecurity.Java_Online_Shop.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Permission extends BaseModal implements GrantedAuthority {
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
