package SpringSecurity.Java_Online_Shop.services.impls;

import SpringSecurity.Java_Online_Shop.modal.Genre;
import SpringSecurity.Java_Online_Shop.modal.Product;
import SpringSecurity.Java_Online_Shop.repositories.GenreRepository;
import SpringSecurity.Java_Online_Shop.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;


    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenre(Long id) {
        return genreRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
