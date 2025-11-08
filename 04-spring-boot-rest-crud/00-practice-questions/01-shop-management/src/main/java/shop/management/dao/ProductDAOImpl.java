package shop.management.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import shop.management.entity.Product;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    private EntityManager entityManager;

    public ProductDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Product save(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class,id);
    }


    @Override
    public void deleteById(int id) {
        Product product = entityManager.find(Product.class,id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> theQuery = entityManager.createQuery("FROM Product",Product.class);
        List<Product> list = theQuery.getResultList();
        return list;
    }

    @Override
    public Product findByName(String name) {
        Product product = entityManager.find(Product.class,name);
        return product;
    }

    @Override
    public void deleteByName(String name) {
        Product product = findByName(name);
        entityManager.remove(product);
    }

    @Override
    public Product updateStock(int id, int newStock) {
        Product product = entityManager.find(Product.class,id);
        product.setStock(newStock);
        return entityManager.merge(product);
    }

}
