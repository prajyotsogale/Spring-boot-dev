package shop.management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.management.dao.ProductDAO;
import shop.management.entity.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    public ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }


    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findByName(String name) {
        return productDAO.findByName(name);
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        productDAO.deleteByName(name);
    }

    @Transactional
    @Override
    public Product updateStock(int id, int newStock) {
        return productDAO.updateStock(id,newStock);
    }

    @Transactional
    @Override
    public void purchaseProduct(int id, int quantity) {
        Product product = productDAO.findById(id);
        int availableStock = product.getStock();
        int stocks = availableStock - quantity;
        if(stocks<0){
            throw new RuntimeException("Not available this much, available stock: "+availableStock);
        }
        product.setStock(stocks);
        productDAO.save(product);
        System.out.println("Done");
    }
}
