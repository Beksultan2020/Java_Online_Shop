package SpringSecurity.Java_Online_Shop.services;


import SpringSecurity.Java_Online_Shop.modal.Product;
import SpringSecurity.Java_Online_Shop.modal.ShoppingCart;

public interface ShoppingCartService {


    ShoppingCart addCart(Product product);
}
