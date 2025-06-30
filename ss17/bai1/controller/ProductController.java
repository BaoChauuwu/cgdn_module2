package ss17.bai1.controller;

import ss17.bai1.model.entity.Product;
import ss17.bai1.service.IProductService;
import ss17.bai1.service.ProductService;

import java.util.Scanner;

public class ProductController {
    private IProductService productService;
    private Scanner scanner;

    public ProductController() {
        this.productService = new ProductService();
        this.scanner = new Scanner(System.in);
    }

    public void addProduct() {
        System.out.println("\n========== THÊM SẢN PHẨM MỚI ==========");
        
        System.out.print("Nhập mã sản phẩm: ");
        String productId = scanner.nextLine().trim();
        
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine().trim();
        
        System.out.print("Nhập giá sản phẩm: ");
        double price;
        try {
            price = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Giá không hợp lệ!");
            return;
        }
        
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine().trim();
        
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine().trim();
        
        Product product = new Product(productId, productName, price, manufacturer, description);
        productService.addProduct(product);
    }

    public void displayAllProducts() {
        System.out.println("\n========== DANH SÁCH SẢN PHẨM ==========");
        productService.displayAllProducts();
    }

} 