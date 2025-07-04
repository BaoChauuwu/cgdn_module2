package test_final.view;

import test_final.model.controller.CarMoonManagement;
import test_final.model.controller.DroneManagement;
import test_final.model.entity.NotFoundVehicleException;

import java.util.Scanner;

public class MainView {
    private static final Scanner sc = new Scanner(System.in);
    private static final DroneManagement droneManagement = new DroneManagement();
    private static final CarMoonManagement carMoonManagement = new CarMoonManagement();
    private static boolean isRunning = true;

    public static void main(String[] args) {
        while (isRunning) {
            displayMenu();
        }
    }

    public static void displayMenu() {
        System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN THÁM HIỂM");
        System.out.println("1. Thêm mới phương tiện");
        System.out.println("2. Hiển thị phương tiện");
        System.out.println("3. Tìm kiếm phương tiện");
        System.out.println("4. Xóa phương tiện");
        System.out.println("5. Thoát");
        System.out.print("Chọn chức năng: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addVehicleMenu();
                    break;
                case 2:
                    displayVehicleMenu();
                    break;
                case 3:
                    searchVehicleMenu();
                    break;
                case 4:
                    deleteVehicleMenu();
                    break;
                case 5:
                    System.out.println("Thoát chương trình...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1-5.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        }
    }

    private static void addVehicleMenu() {
        System.out.println("\n===== THÊM MỚI PHƯƠNG TIỆN =====");
        System.out.println("1. Thêm Drone bay");
        System.out.println("2. Thêm Xe tuần tra mặt trăng");
        System.out.print("Chọn loại phương tiện: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    droneManagement.addDrone();
                    break;
                case 2:
                    carMoonManagement.addCarMoon();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void displayVehicleMenu() {
        System.out.println("\n===== HIỂN THỊ PHƯƠNG TIỆN =====");
        System.out.println("1. Hiển thị Drone bay");
        System.out.println("2. Hiển thị Xe tuần tra mặt trăng");
        System.out.print("Chọn loại phương tiện: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    droneManagement.displayAllDrones();
                    break;
                case 2:
                    carMoonManagement.displayAllCarMoons();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        }
    }

    private static void searchVehicleMenu() {
        System.out.println("\n===== TÌM KIẾM PHƯƠNG TIỆN =====");
        System.out.println("1. Tìm kiếm Drone bay");
        System.out.println("2. Tìm kiếm Xe tuần tra mặt trăng");
        System.out.print("Chọn loại phương tiện: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    droneManagement.searchDrone();
                    break;
                case 2:
                    carMoonManagement.searchCarMoon();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        }
    }

    private static void deleteVehicleMenu() {
        System.out.println("\n===== XÓA PHƯƠNG TIỆN =====");
        System.out.println("1. Xóa Drone bay");
        System.out.println("2. Xóa Xe tuần tra mặt trăng");
        System.out.print("Chọn loại phương tiện: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    droneManagement.deleteDrone();
                    break;
                case 2:
                    carMoonManagement.deleteCarMoon();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (NotFoundVehicleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
    }
}
