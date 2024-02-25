package SpringSecurity.Java_Online_Shop.repositories;


import SpringSecurity.Java_Online_Shop.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    List<User> findAllByFullNameContainsIgnoreCase(String name);


}
