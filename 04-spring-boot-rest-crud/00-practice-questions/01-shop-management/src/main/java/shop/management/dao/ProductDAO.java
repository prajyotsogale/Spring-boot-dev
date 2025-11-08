package shop.management.dao;

import shop.management.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product save(Product product);
    Product findById(int id);
    void deleteById(int id);
    List<Product> findAll();
    Product findByName(String name);
    void deleteByName(String name);
    Product updateStock(int id, int newStock);
}
