package SpringSecurity.Java_Online_Shop.services;


import SpringSecurity.Java_Online_Shop.modal.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    void addProduct(Product product);

    Product getProduct(Long id);

    Product updateProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getAllProductsByGenresId(Long id);


    List<Product> getSortedProducts(String sortOption);

    /*List<Product> searchProduct*/

//    double calculateAverageMark(Long productId);
}
