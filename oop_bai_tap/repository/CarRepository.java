package oop_bai_tap.repository;

import oop_bai_tap.entity.Car;
import oop_bai_tap.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {

    private final boolean APPEND = true;

    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFromFile("oop_bai_tap/data/car.csv");
        String[] aray = null;
        for (String line : stringList) {
            aray = line.split(",");
            Car car = new Car(aray[0],aray[1],Integer.parseInt(aray[2]),aray[3],Integer.parseInt(aray[4]),aray[5]);
            carList.add(car);
        }
        return carList;

    }

    @Override
    public void addCar(Car car) {
        List<String> carList = new ArrayList<>();
        carList.add(car.getInfoToCSV());
        ReadAndWriteFile.writeToFile("oop_bai_tap/data/car.csv",carList,APPEND);
    }

    @Override
    public boolean deleteCar(Car car) {
        return false;
    }
}
