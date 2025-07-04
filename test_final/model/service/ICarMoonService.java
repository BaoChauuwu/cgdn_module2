package test_final.model.service;

import test_final.model.entity.CarMoon;

import java.util.List;

public interface ICarMoonService {
    List<CarMoon> findAllCarMoon();
    void addCarMoon(CarMoon carMoon);
    CarMoon findCarMoonByCode(String code);
    void deleteCarMoonByCode(String code);
    boolean isExistCarMoon(String code);
}
