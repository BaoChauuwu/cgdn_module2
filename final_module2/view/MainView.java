package final_module2.view;

import final_module2.controller.ManagementContact;

import java.util.Scanner;

public class MainView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ManagementContact managementContact = new ManagementContact();
    private  static boolean flags= true;
    public static void main(String[] args) {
        while (flags) {
            displayMenu();
        }
    }
    public static void displayMenu(){
        System.out.println("\n------ CHƯƠNG TRÌNH QUẢNG LÝ DANH BẠ ------");
        System.out.println("Chọn chức năng theo số (để tiếp tục): ");
        System.out.println("1.Xem danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhập");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Đọc từ file");
        System.out.println("7.Ghi vào file");
        System.out.println("8.Thoát");
        System.out.println("Chọn chức năng: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managementContact.displayAllContact();
                    break;
                case 2:
                    managementContact.addContact();
                    break;
                case 3:
                    managementContact.updateContact();
                    break;
                case 4:
                    managementContact.deleteContact();
                    break;
                case 5:
                    managementContact.searchContact();
                    break;
                case 6:
                    managementContact.readFromFile();
                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Thoát chương trình ....");
                    flags = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại lựa chọn từ 1-8!");
            }

        }catch (NumberFormatException e){
            System.out.println("Vui lòng nhập số hợp lệ");
        }
    }
}
