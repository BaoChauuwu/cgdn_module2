package ss17.bai1.model.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String productId;
    private String productName;
    private double price;
    private String manufacturer;
    private String description;

    public Product() {
    }

    public Product(String productId, String productName, double price, String manufacturer, String description) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %,15.2f đ | %-15s | %s", 
                productId, productName, price, manufacturer, description);
    }

    public String toDisplayFormat() {
        return "Mã SP: " + productId + "\n" +
               "Tên SP: " + productName + "\n" +
               "Giá: " + String.format("%,.2f", price) + " đ\n" +
               "Hãng SX: " + manufacturer + "\n" +
               "Mô tả: " + description + "\n" +
               "----------------------------------------";
    }
} 