package SpringSecurity.Java_Online_Shop.repositories;

import SpringSecurity.Java_Online_Shop.modal.Genre;
import SpringSecurity.Java_Online_Shop.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Long> {

/*Genre findByGenreName(Genre genre);*/
}
