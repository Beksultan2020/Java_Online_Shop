package SpringSecurity.Java_Online_Shop.services;

import SpringSecurity.Java_Online_Shop.modal.Genre;
import SpringSecurity.Java_Online_Shop.modal.Product;

import java.util.List;

public interface GenreService {
    /*List<Product> getAllProductsByGenre(Long id);*/

    List<Genre> getAllGenres();

    Genre getGenre(Long id);

    void deleteGenre(Long id);
}
