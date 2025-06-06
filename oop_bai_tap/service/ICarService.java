package oop_bai_tap.service;

import oop_bai_tap.entity.Car;

import java.util.List;

public interface ICarService {
    void addCar(Car car);
    List<Car> getCarList();
}
