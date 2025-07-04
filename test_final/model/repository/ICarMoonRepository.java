package test_final.model.repository;

import test_final.model.entity.CarMoon;

import java.util.List;

public interface ICarMoonRepository {
    List<CarMoon> findAllCarMoon();
    void addCarMoon(CarMoon carMoon);
    CarMoon findCarMoonByCode(String code);
    void deleteCarMoonByCode(String code);
    boolean isExistCarMoon(String code);

}
