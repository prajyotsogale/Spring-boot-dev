package shop.management.service;

import shop.management.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product findById(int id);

    void deleteById(int id);
    List<Product> findAll();
    Product findByName(String name);
    void deleteByName(String name);
    Product updateStock(int id, int newStock);
    void purchaseProduct(int id, int quantity);

}
