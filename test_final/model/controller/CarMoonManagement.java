package test_final.model.controller;

import test_final.model.entity.CarMoon;
import test_final.model.entity.NotFoundVehicleException;
import test_final.model.service.CarMoonService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CarMoonManagement {
    private CarMoonService carMoonService = new CarMoonService();
    private Scanner sc = new Scanner(System.in);

    private boolean checkIsEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public void addCarMoon() {
        System.out.println("=== THÊM MỚI XE TUẦN TRA MẶT TRĂNG ===");
        System.out.println("Lưu ý: Số hiệu phải theo định dạng XTT-XXX (ví dụ: XTT-001)");
        System.out.println("Cấp độ chống bức xạ: 1-10 (ví dụ: Cấp 5)");

        System.out.print("Nhập số hiệu: ");
        String code = sc.nextLine();

        System.out.print("Nhập hãng chế tạo: ");
        String manufacturer = sc.nextLine();

        System.out.print("Nhập năm sản xuất: ");
        String year = sc.nextLine();

        System.out.print("Nhập người điều phối: ");
        String namePerson = sc.nextLine();

        System.out.print("Nhập khả năng chống bức xạ: ");
        String levelSafe = sc.nextLine();

        if (checkIsEmpty(code)) {
            System.out.println("Số hiệu không được để trống!");
            return;
        }

        if (!code.matches("^XTT-\\d{3}$")) {
            System.out.println("Số hiệu phải có định dạng XTT-XXX (ví dụ: XTT-001)!");
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

        if (checkIsEmpty(levelSafe)) {
            System.out.println("Khả năng chống bức xạ không được để trống!");
            return;
        }

        String cleanLevel = levelSafe.trim().toLowerCase();
        if (cleanLevel.startsWith("cấp ")) {
            cleanLevel = cleanLevel.substring(4).trim();
        }

        try {
            int level = Integer.parseInt(cleanLevel);
            if (level < 1 || level > 10) {
                System.out.println("Cấp độ chống bức xạ phải từ 1 đến 10!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Cấp độ chống bức xạ phải là số từ 1-10!");
            return;
        }

        if (carMoonService.isExistCarMoon(code)) {
            System.out.println("Số hiệu xe tuần tra đã tồn tại!");
            return;
        }

        CarMoon carMoon = new CarMoon(code, manufacturer, year, namePerson, levelSafe);
        carMoonService.addCarMoon(carMoon);
        System.out.println("Thêm xe tuần tra mặt trăng thành công!");
    }

    public void displayAllCarMoons() {
        System.out.println("=== DANH SÁCH XE TUẦN TRA MẶT TRĂNG ===");
        List<CarMoon> carMoons = carMoonService.findAllCarMoon();
        if (carMoons.isEmpty()) {
            System.out.println("Không có xe tuần tra nào trong danh sách.");
        } else {
            for (CarMoon carMoon : carMoons) {
                System.out.println(carMoon);
            }
        }
    }

    public void searchCarMoon() {
        System.out.println("=== TÌM KIẾM XE TUẦN TRA MẶT TRĂNG ===");
        System.out.println("1. Tìm theo số hiệu");
        System.out.println("2. Tìm theo tên người điều phối");
        System.out.print("Chọn cách tìm kiếm: ");
        int choice = Integer.parseInt(sc.nextLine());

        CarMoon carMoon = null;
        switch (choice) {
            case 1:
                System.out.print("Nhập số hiệu: ");
                String code = sc.nextLine();
                carMoon = carMoonService.findCarMoonByCode(code);
                break;
            case 2:
                System.out.print("Nhập tên người điều phối: ");
                String namePerson = sc.nextLine();
                carMoon = carMoonService.findCarMoonByNamePerson(namePerson);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (carMoon != null) {
            System.out.println("Thông tin xe tuần tra mặt trăng:");
            System.out.println(carMoon);
        } else {
            System.out.println("Không tìm thấy phương tiện phù hợp.");
        }
    }

    public void deleteCarMoon() throws NotFoundVehicleException {
        System.out.println("=== XÓA XE TUẦN TRA MẶT TRĂNG ===");
        System.out.print("Nhập số hiệu đăng ký: ");
        String code = sc.nextLine();

        CarMoon carMoon = carMoonService.findCarMoonByCode(code);
        if (carMoon == null) {
            throw new NotFoundVehicleException("Số hiệu phương tiện không tồn tại.");
        }

        System.out.println("Thông tin xe tuần tra sẽ bị xóa:");
        System.out.println(carMoon);

        System.out.print("Bạn có chắc chắn muốn xóa? (Yes/No): ");
        String confirm = sc.nextLine();

        if ("Yes".equalsIgnoreCase(confirm)) {
            carMoonService.deleteCarMoonByCode(code);
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Hủy thao tác xóa.");
        }
    }
}
