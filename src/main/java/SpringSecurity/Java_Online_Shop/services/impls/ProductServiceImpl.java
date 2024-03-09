package SpringSecurity.Java_Online_Shop.services.impls;

import SpringSecurity.Java_Online_Shop.modal.Comment;
import SpringSecurity.Java_Online_Shop.modal.Genre;
import SpringSecurity.Java_Online_Shop.repositories.CommentRepository;
import SpringSecurity.Java_Online_Shop.repositories.GenreRepository;
import SpringSecurity.Java_Online_Shop.repositories.ProductRepository;
import SpringSecurity.Java_Online_Shop.modal.Product;
import SpringSecurity.Java_Online_Shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final GenreRepository genreRepository;
    private final CommentRepository commentRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();

        if (productList.size() > 0) {
            return productList;
        } else {
            return null;
        }
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public Product updateProduct(Product product) {
        if (product == null) {
            return null;
        }

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProductsByGenresId(Long id) {
        List<Product> product=productRepository.findByGenresList_Id(id);
        if(product!=null){
            return product;
        }
        return null;
    }

    @Override
    public List<Product> getSortedProducts(String sortOption) {
        if (sortOption.equals("acs")){
            return productRepository.findAllByOrderByNameAsc();
        }
        else if(sortOption.equals("desc")){
            return productRepository.findAllByOrderByNameDesc();
        }
        else {
            return productRepository.findAll();
        }
    }

//    @Override
//    public double calculateAverageMark(Long productId) {
//        List<Comment> comments=commentRepository.findAllById(productId);
//    }

    /*@Override
    public String calculateMark(Integer mark) {
        if(mark==null){
            return null;
        }
        switch (mark){
            case 1:
                return "Крайне отрицательный";
            case 2:
                return "отрицательный";
            case 3:
                return "смешанный";
            case 4:
                return "положительный";
            case 5:
                return "Крайне положительные";
            default:
                return null;
        }
    }*/
}
