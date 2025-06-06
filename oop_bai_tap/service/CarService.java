package oop_bai_tap.service;

import oop_bai_tap.entity.Car;

import oop_bai_tap.repository.CarRepository;

import java.util.List;

public class CarService implements ICarService {
    CarRepository carRepository = new CarRepository();
    @Override
    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    @Override
    public List<Car> getCarList() {
        return carRepository.getCarList();
    }
}
