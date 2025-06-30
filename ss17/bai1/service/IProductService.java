package ss17.bai1.service;

import ss17.bai1.model.entity.Product;

public interface IProductService {

    boolean addProduct(Product product);

    void displayAllProducts();

} 