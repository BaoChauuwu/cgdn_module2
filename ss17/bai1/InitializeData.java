package ss17.bai1;

import ss17.bai1.model.entity.Product;
import ss17.bai1.util.BinaryFileHelper;

import java.util.ArrayList;
import java.util.List;

public class InitializeData {
    public static void main(String[] args) {
        System.out.println("Khởi tạo dữ liệu mẫu...");
        
        List<Product> sampleProducts = new ArrayList<>();
        
        sampleProducts.add(new Product("SP001", "iPhone 15 Pro", 25000000, "Apple", "Điện thoại thông minh cao cấp"));
        sampleProducts.add(new Product("SP002", "Samsung Galaxy S24", 22000000, "Samsung", "Điện thoại Android flagship"));
        sampleProducts.add(new Product("SP003", "MacBook Air M2", 28000000, "Apple", "Laptop cao cấp cho công việc"));
        sampleProducts.add(new Product("SP004", "Dell XPS 13", 25000000, "Dell", "Laptop business premium"));
        sampleProducts.add(new Product("SP005", "Sony WH-1000XM5", 8000000, "Sony", "Tai nghe chống ồn cao cấp"));
        
        BinaryFileHelper.saveProducts(sampleProducts);

    }
} 