package ss16;

import java.io.*;
import java.util.Scanner;

public class FileCopyProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = scanner.nextLine();

        System.out.print("Nhập đường dẫn tệp đích: ");
        String targetPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        if (!sourceFile.exists()) {
            System.err.println("Tệp nguồn không tồn tại.");
            return;
        }

        if (targetFile.exists()) {
            System.err.println("Tệp đích đã tồn tại. Không ghi đè.");
            return;
        }

        int byteCount = 0;

        try (
                FileInputStream inputStream = new FileInputStream(sourceFile);
                FileOutputStream outputStream = new FileOutputStream(targetFile);
        ) {
            int byteData;
            while ((byteData = inputStream.read()) != -1) {
                outputStream.write(byteData);
                byteCount++;
            }

            System.out.println("Sao chép thành công.");
            System.out.println("Tổng số byte đã sao chép: " + byteCount);

        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi sao chép tệp: " + e.getMessage());
        }

        scanner.close();
    }
}
