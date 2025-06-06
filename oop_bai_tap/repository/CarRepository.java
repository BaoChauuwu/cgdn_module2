package oop_bai_tap.repository;

import oop_bai_tap.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
     List<Car> carList = new ArrayList<>();
    public CarRepository() {
        carList.add(new Car("43A-212.56","Toyota",2019,"Nguyễn Văn A",5,"Du Lich"));
        carList.add(new Car("43B-453.88","Huyndai",2020,"Nguyễn Văn B",45,"Xe khách"));
        carList.add(new Car( "43B-453.89","Ford",2020,"Nguyễn Văn C",16,"Xe Khách"));
    }
    public void addCar(Car car){
        carList.add(car);
    }
    public List<Car> getCarList(){
        return carList;
    }
    public void findCarByLicensePlate(String licensePlate){
        carList.removeIf(car -> car.getLicensePlate().equals(licensePlate));
    }
}
