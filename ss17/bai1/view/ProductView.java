package ss17.bai1.view;

import ss17.bai1.controller.ProductController;

import java.util.Scanner;

public class ProductView {
    private ProductController productController;
    private Scanner scanner;

    public ProductView() {
        this.productController = new ProductController();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ProductView productView = new ProductView();
        productView.displayMainMenu();
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("    QUẢN LÝ SẢN PHẨM - ĐƠN GIẢN");
            System.out.println("=".repeat(40));
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị tất cả sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("0. Thoát");
            System.out.println("=".repeat(40));
            System.out.print("Nhập lựa chọn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    productController.addProduct();
                    break;
                case "2":
                    productController.displayAllProducts();
                    break;
                case "0":
                    System.out.println("\nCảm ơn bạn đã sử dụng chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ! Vui lòng chọn 0-3.");
            }

            if (!choice.equals("0")) {
                System.out.println("\nNhấn Enter để tiếp tục...");
                scanner.nextLine();
            }
        }
    }
} 