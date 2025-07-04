package test_final.model.service;

import test_final.model.entity.CarMoon;
import test_final.model.repository.CarMoonRepository;
import test_final.model.repository.ICarMoonRepository;

import java.util.List;

public class CarMoonService implements ICarMoonService {
    private ICarMoonRepository carMoonRepository = new CarMoonRepository();
    
    @Override
    public List<CarMoon> findAllCarMoon() {
        return carMoonRepository.findAllCarMoon();
    }

    @Override
    public void addCarMoon(CarMoon carMoon) {
        if (carMoon != null && !isExistCarMoon(carMoon.getCode())) {
            carMoonRepository.addCarMoon(carMoon);
        } else {
            System.out.println("Xe tuần tra đã tồn tại");
        }
    }

    @Override
    public CarMoon findCarMoonByCode(String code) {
        return carMoonRepository.findCarMoonByCode(code);
    }

    @Override
    public void deleteCarMoonByCode(String code) {
        if (carMoonRepository.findCarMoonByCode(code) != null) {
            carMoonRepository.deleteCarMoonByCode(code);
        } else {
            System.out.println("CarMoon not found");
        }
    }

    @Override
    public boolean isExistCarMoon(String code) {
       return  carMoonRepository.isExistCarMoon(code);
    }
    
    public CarMoon findCarMoonByNamePerson(String namePerson) {
        List<CarMoon> allCarMoons = findAllCarMoon();
        for (CarMoon carMoon : allCarMoons) {
            if (carMoon.getNamePerson().equalsIgnoreCase(namePerson)) {
                return carMoon;
            }
        }
        return null;
    }
}
