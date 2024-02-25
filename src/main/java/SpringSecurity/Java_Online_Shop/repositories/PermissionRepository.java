package SpringSecurity.Java_Online_Shop.repositories;


import SpringSecurity.Java_Online_Shop.modal.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission,Long> {

    Permission findByRole(String role);

}
