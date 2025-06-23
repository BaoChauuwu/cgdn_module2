package oop_bai_tap.repository;

import oop_bai_tap.entity.Car;


import java.util.List;

public interface ICarRepository {
  List <Car> findAll();
  void addCar(Car car);
  boolean deleteCar(Car car);
}
