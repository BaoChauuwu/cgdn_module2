package ss17.bai1.model.repository;

import ss17.bai1.model.entity.Product;

import java.util.List;

public interface IProductRepository {

    void addProduct(Product product);
    

    List<Product> getAllProducts();

    void saveToFile();

    void loadFromFile();
} 