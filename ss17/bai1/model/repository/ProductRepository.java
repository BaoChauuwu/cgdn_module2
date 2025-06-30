package ss17.bai1.model.repository;

import ss17.bai1.model.entity.Product;
import ss17.bai1.util.BinaryFileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository implements IProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
        loadFromFile();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
        saveToFile();
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void saveToFile() {
        BinaryFileHelper.saveProducts(products);
    }

    @Override
    public void loadFromFile() {
        this.products = BinaryFileHelper.loadProducts();
    }
} 