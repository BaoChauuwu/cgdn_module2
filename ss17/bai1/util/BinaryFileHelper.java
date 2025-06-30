package ss17.bai1.util;

import ss17.bai1.model.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileHelper {
    private static final String DATA_FILE = "ss17/bai1/data/products.dat";

    public static void saveProducts(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(products);
            System.out.println("Đã lưu " + products.size() + " sản phẩm vào file nhị phân.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static List<Product> loadProducts() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("File dữ liệu chưa tồn tại. Tạo danh sách mới.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            @SuppressWarnings("unchecked")
            List<Product> products = (List<Product>) ois.readObject();
            System.out.println("Đã tải " + products.size() + " sản phẩm từ file nhị phân.");
            return products;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
