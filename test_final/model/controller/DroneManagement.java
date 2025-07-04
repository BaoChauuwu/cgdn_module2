package test_final.model.controller;

import test_final.model.entity.Drone;
import test_final.model.entity.NotFoundVehicleException;
import test_final.model.service.DroneService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DroneManagement {
    private DroneService droneService = new DroneService();
    private Scanner sc = new Scanner(System.in);

    private boolean checkIsEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public void addDrone() {
        System.out.println("=== THÊM MỚI DRONE BAY ===");
        System.out.println("Lưu ý: Số hiệu phải theo định dạng DRN-XXX (ví dụ: DRN-001)");

        System.out.print("Nhập số hiệu: ");
        String code = sc.nextLine();

        System.out.print("Nhập hãng chế tạo: ");
        String manufacturer = sc.nextLine();

        System.out.print("Nhập năm sản xuất: ");
        String year = sc.nextLine();

        System.out.print("Nhập người điều phối: ");
        String namePerson = sc.nextLine();

        System.out.print("Nhập tầm bay tối đa (km): ");
        String flyRangeStr = sc.nextLine();

        if (checkIsEmpty(code)) {
            System.out.println("Số hiệu không được để trống!");
            return;
        }

        if (!code.matches("^DRN-\\d{3}$")) {
            System.out.println("Số hiệu phải có định dạng DRN-XXX (ví dụ: DRN-001)!");
            return;
        }

        if (checkIsEmpty(manufacturer)) {
            System.out.println("Hãng chế tạo không được để trống!");
            return;
        }

        if (checkIsEmpty(year)) {
            System.out.println("Năm sản xuất không được để trống!");
            return;
        }

        try {
            int yearInt = Integer.parseInt(year);
            if (yearInt > LocalDate.now().getYear()) {
                System.out.println("Năm sản xuất không được lớn hơn năm hiện tại!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Năm sản xuất phải là số!");
            return;
        }

        if (checkIsEmpty(namePerson)) {
            System.out.println("Tên người điều phối không được để trống!");
            return;
        }

        if (checkIsEmpty(flyRangeStr)) {
            System.out.println("Tầm bay không được để trống!");
            return;
        }

        try {
            Double flyRange = Double.parseDouble(flyRangeStr);
            if (flyRange <= 0) {
                System.out.println("Tầm bay phải là số dương!");
                return;
            }

            if (droneService.isExistDroneCode(code)) {
                System.out.println("Số hiệu drone đã tồn tại!");
                return;
            }

            Drone drone = new Drone(code, manufacturer, year, namePerson, flyRange);
            droneService.addDrone(drone);
            System.out.println("Thêm drone thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Tầm bay phải là số!");
        }
    }

    public void displayAllDrones() {
        System.out.println("=== DANH SÁCH DRONE BAY ===");
        List<Drone> drones = droneService.findAllDrone();
        if (drones.isEmpty()) {
            System.out.println("Không có drone nào trong danh sách.");
        } else {
            System.out.println("DroneList");
            System.out.println("------------------------------------------------------------------------");
            for (Drone drone : drones) {
                System.out.println(drone);
            }
        }
    }

    public void searchDrone() {
        System.out.println("=== TÌM KIẾM DRONE ===");
        System.out.println("1. Tìm theo số hiệu");
        System.out.println("2. Tìm theo tên người điều phối");
        System.out.print("Chọn cách tìm kiếm: ");
        int choice = Integer.parseInt(sc.nextLine());

        Drone drone = null;
        switch (choice) {
            case 1:
                System.out.print("Nhập số hiệu: ");
                String code = sc.nextLine();
                drone = droneService.findDroneByCode(code);
                break;
            case 2:
                System.out.print("Nhập tên người điều phối: ");
                String namePerson = sc.nextLine();
                drone = droneService.findDroneByNamePerson(namePerson);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (drone != null) {
            System.out.println("Thông tin drone:");
            System.out.println(drone);
        } else {
            System.out.println("Không tìm thấy phương tiện phù hợp.");
        }
    }

    public void deleteDrone() throws NotFoundVehicleException {
        System.out.println("=== XÓA DRONE ===");
        System.out.print("Nhập số hiệu đăng ký: ");
        String code = sc.nextLine();

        Drone drone = droneService.findDroneByCode(code);
        if (drone == null) {
            throw new NotFoundVehicleException("Số hiệu phương tiện không tồn tại.");
        }

        System.out.println(drone);

        System.out.print("Bạn có chắc chắn muốn xóa? (Yes/No): ");
        String confirm = sc.nextLine();

        if ("Yes".equalsIgnoreCase(confirm)) {
            droneService.deleteDroneByCode(code);
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Hủy thao tác xóa.");
        }
    }
}
