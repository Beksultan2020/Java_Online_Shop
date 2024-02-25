package SpringSecurity.Java_Online_Shop.api;


import SpringSecurity.Java_Online_Shop.modal.Product;
import SpringSecurity.Java_Online_Shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "{id}")
    public Product getProduct(@PathVariable(value = "id") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping(value = "/findProducts/{id}")
    public List<Product> getAllProductsByGenre(@PathVariable(value = "id")Long id){
        return productService.getAllProductsByGenresId(id);
    }

    @GetMapping(value = "/sortedProducts/{sortOption}")
    public List<Product> getSortedProducts(@PathVariable(value = "sortOption")String sortOption){
        return productService.getSortedProducts(sortOption);
    }
}
