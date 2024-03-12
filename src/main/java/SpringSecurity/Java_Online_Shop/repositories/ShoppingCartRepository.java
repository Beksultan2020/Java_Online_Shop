package SpringSecurity.Java_Online_Shop.repositories;

import SpringSecurity.Java_Online_Shop.modal.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

}
