package oop_bai_tap.controller;

import oop_bai_tap.entity.Car;
import oop_bai_tap.entity.Motobike;
import oop_bai_tap.entity.Truck;
import oop_bai_tap.service.*;
import oop_bai_tap.view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private ITruckService iTruckService = new TruckService();
    private ICarService iCarService = new CarService();
    private IMotobikeService iMotobikeService = new MotobikeService();
    private static Scanner sc = new Scanner(System.in);
    MainView mainView = new MainView();

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMenu();

    }

    public void displayMenu() {
        System.out.println("===============================================");
        System.out.println("Chương trình quản lý phương tiện giao thông ");
        System.out.println("Chọn chức năng: ");
        System.out.println("1.Thêm mới phương tiện");
        System.out.println("2.Hiện thị phương tiện");
        System.out.println("3.Xoóa phương tiện");
        System.out.println("4.Thoát");
        System.out.println("Mời bạn nhập lựa chọn của bạn: ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                showAddMenuVehicle();
                break;

            case 2:
                showListVehicles();
                break;

        }

    }

    public void showAddMenuVehicle() {

        int choice = mainView.addView();
        switch (choice) {
            case 1:
                addTruck();
                break;

            case 2:
                addCar();
                break;
            case 3:
                addMotobike();
                break;

        }
    }

    public void showListVehicles() {
        int choice = mainView.listView();
        switch (choice) {
            case 1:
                List<Truck> trucks = iTruckService.getTrucks();
                if (trucks.isEmpty()) {
                    System.out.println("Không có xe tải nào trong hệ thống.");
                } else {
                    System.out.println("Danh sách xe tải:");
                    for (Truck truck : trucks) {
                        System.out.println("Biển số: " + truck.getLicensePlate());
                        System.out.println("Hãng sản xuất: " + truck.getManufacturerName());
                        System.out.println("Năm sản xuất: " + truck.getManufactureYear());
                        System.out.println("Chủ sở hữu: " + truck.getOwnerName());
                        System.out.println("Tải trọng: " + truck.getLoadCapacity() + " tấn");
                        System.out.println("--------------------------------------------");
                    }
                }
                break;
            case 2:
                List<Car> cars = iCarService.getCarList();
                if (cars.isEmpty()) {
                    System.out.println("Không có xe oto nào trong hệ thống.");
                } else {
                    System.out.println("Danh sách xe tải: ");
                    for (Car car : cars) {
                        System.out.println("Biển số: " + car.getLicensePlate());
                        System.out.println("Hãng sản xuất: " + car.getManufactureYear());
                        System.out.println("Năm sản xuất: " + car.getManufactureYear());
                        System.out.println("Chủ sở hữu: " + car.getOwnerName());
                        System.out.println("Số lượng ghế" + car.getSeatCount());
                        System.out.println("Kiểu xe: " + car.getCarType());
                        System.out.println("-----------------------------------------");
                    }
                }
                break;

            case 3:
                List<Motobike> motobikes= iMotobikeService.getListMotobike();
                if (motobikes.isEmpty()) {
                    System.out.println("Không có xe máy nào trong hệ thống");
                }
                else {
                    for (Motobike motobike : motobikes) {
                        System.out.println("Bien so xe" + motobike.getLicensePlate());
                        System.out.println("Hãng sản xuất: " + motobike.getManufacturerName());
                        System.out.println("Năm sản xuất: "+motobike.getManufactureYear());
                        System.out.println("Chủ sỡ huu: "+motobike.getOwnerName());
                        System.out.println("Công suất: "+motobike.getHorsePower());
                        System.out.println("---------------------------------");
                    }
                }
        }
    }

    public void addTruck() {
        System.out.print("Nhập biển số xe tải: ");
        String licensePlate = sc.nextLine();

        System.out.print("Nhập tên hãng sản xuất: ");
        String manufacturerName = sc.nextLine();

        System.out.print("Nhập năm sản xuất: ");
        int manufactureYear = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập chủ sở hữu: ");
        String ownerName = sc.nextLine();
        System.out.print("Nhập tải trọng: ");
        double loadCapacity = Double.parseDouble(sc.nextLine());
        Truck truck = new Truck(licensePlate, manufacturerName, manufactureYear, ownerName, loadCapacity);

        iTruckService.addTruck(truck);

        System.out.println("Xe tải đã được thêm thành công!");
        displayMenu();
    }

    public void addCar() {
        System.out.print("Nhập biển số xe tải: ");
        String licensePlate = sc.nextLine();

        System.out.print("Nhập tên hãng sản xuất: ");
        String manufacturerName = sc.nextLine();

        System.out.print("Nhập năm sản xuất: ");
        int manufactureYear = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập chủ sở hữu: ");
        String ownerName = sc.nextLine();

        System.out.print("Nhập số lượng ghế ngoi: ");
        Integer seatCount = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập kiểu xe: ");
        String carType = sc.nextLine();

        Car car = new Car(licensePlate, manufacturerName, manufactureYear, ownerName, seatCount, carType);
        iCarService.addCar(car);

        System.out.println("Xe tai duoc them thanh cong");
        displayMenu();
    }

    public void addMotobike() {
        System.out.print("Nhập biển số xe tải: ");
        String licensePlate = sc.nextLine();

        System.out.print("Nhập tên hãng sản xuất: ");
        String manufacturerName = sc.nextLine();

        System.out.print("Nhập năm sản xuất: ");
        int manufactureYear = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String ownerName = sc.nextLine();
        System.out.print("Nhập công suất: ");
        double horsePower = Double.parseDouble(sc.nextLine());

        Motobike motobike = new Motobike(licensePlate, manufacturerName, manufactureYear, ownerName, horsePower);
        iMotobikeService.addMotobike(motobike);

        System.out.println("Xe máy đuược thêm thành công: ");
        displayMenu();

    }
}
