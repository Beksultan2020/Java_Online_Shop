package SpringSecurity.Java_Online_Shop.api;


import SpringSecurity.Java_Online_Shop.modal.Genre;
import SpringSecurity.Java_Online_Shop.services.impls.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    @Autowired
    private GenreServiceImpl genreService;
    @GetMapping
    public List<Genre> getAllProductsByGenreId(){
        return genreService.getAllGenres();
    }

    @GetMapping(value = "{id}")
    public Genre getGenre(@PathVariable(value = "id")Long id){
        return genreService.getGenre(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteGenre(@PathVariable(value = "id")Long id){
        genreService.deleteGenre(id);
    }
}
