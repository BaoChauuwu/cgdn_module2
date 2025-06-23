package oop_bai_tap.service;

import oop_bai_tap.entity.Car;

import java.util.List;

public interface ICarService {
    List <Car> findAll();
    void addCar(Car car);
    boolean deleteCar(Car car);
}
