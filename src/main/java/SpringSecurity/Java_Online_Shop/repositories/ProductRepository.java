package SpringSecurity.Java_Online_Shop.repositories;

import SpringSecurity.Java_Online_Shop.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByGenresList_Id(Long genreId);

    List<Product> findByGenresList_GenreName(String genreName);

    List<Product> findAllByOrderByNameAsc();

    List<Product> findAllByOrderByNameDesc();

    boolean existsById(Long id);

    //todo
}
