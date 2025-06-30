package oop_bai_tap.repository;

import oop_bai_tap.entity.Car;
import oop_bai_tap.entity.Motobike;

import java.util.List;

public interface IMotobikeRepository {
    List<Motobike> findAll();
    void addMotobikeToCar(Car car);
    boolean deleteMotobikeFromCar(Car car);
    void addMotobike(Motobike motobike);
    List<Motobike> getListMotobike();
}
