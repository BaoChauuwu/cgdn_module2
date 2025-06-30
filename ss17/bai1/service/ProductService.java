package ss17.bai1.service;

import ss17.bai1.model.entity.Product;
import ss17.bai1.model.repository.IProductRepository;
import ss17.bai1.model.repository.ProductRepository;
import ss17.bai1.util.BinaryFileHelper;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    @Override
    public boolean addProduct(Product product) {
        if (!validateProduct(product)) {
            System.out.println("Thông tin sản phẩm không hợp lệ!");
            return false;
        }
        
        try {
            productRepository.addProduct(product);
            System.out.println(" Thêm sản phẩm thành công!");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(" Lỗi: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void displayAllProducts() {
        List<Product> products = productRepository.getAllProducts();
        
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào trong hệ thống.");
            return;
        }

        System.out.printf("%-10s | %-20s | %-15s | %-15s | %s%n", 
                "Mã SP", "Tên SP", "Giá", "Hãng SX", "Mô tả");
        System.out.println("─".repeat(85));
        
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println("─".repeat(85));
        System.out.println("Tổng số sản phẩm: " + products.size());
    }


    private boolean validateProduct(Product product) {
        if (product == null) {
            System.out.println("Sản phẩm không được null!");
            return false;
        }
        
        if (product.getProductId() == null || product.getProductId().trim().isEmpty()) {
            System.out.println("Mã sản phẩm không được để trống!");
            return false;
        }
        
        if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            System.out.println("Tên sản phẩm không được để trống!");
            return false;
        }
        
        if (product.getPrice() < 0) {
            System.out.println("Giá sản phẩm phải >= 0!");
            return false;
        }
        
        if (product.getManufacturer() == null || product.getManufacturer().trim().isEmpty()) {
            System.out.println("Hãng sản xuất không được để trống!");
            return false;
        }
        
        return true;
    }
} 