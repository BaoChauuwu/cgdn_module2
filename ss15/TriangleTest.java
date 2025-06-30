package ss15;


import java.util.Scanner;

public class TriangleTest  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập cạnh thứ nhất: ");
            double a = scanner.nextDouble();
            System.out.print("Nhập cạnh thứ hai: ");
            double b = scanner.nextDouble();
            System.out.print("Nhập cạnh thứ ba: ");
            double c = scanner.nextDouble();

            validateTriangle(a, b, c);

            System.out.println("Ba cạnh này tạo thành một tam giác hợp lệ.");

        } catch (IllegalTriangleException e) {
            System.err.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Đầu vào không hợp lệ. Vui lòng nhập số.");
        }

        scanner.close();
    }

    public static void validateTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Các cạnh phải là số dương.");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh phải lớn hơn cạnh còn lại.");
        }
    }
}
