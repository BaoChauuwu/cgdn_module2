package test_final.model.repository;

import test_final.model.entity.CarMoon;
import test_final.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CarMoonRepository implements ICarMoonRepository {
    private final boolean APPEND = true;
    @Override
    public List<CarMoon> findAllCarMoon() {
        List<CarMoon> listCarMoon = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFromFile("test_final/data/xeTuanTra.csv");
        String [] array = null;
        for (String string : stringList) {
            array = string.split(",");
            CarMoon carMoon = new CarMoon(array[0],array[1],array[2],array[3],array[4]);
            listCarMoon.add(carMoon);
        }
        return listCarMoon;
    }

    @Override
    public void addCarMoon(CarMoon carMoon) {
        List<String> carMoonList = new ArrayList<>();
        carMoonList.add(carMoon.getInfoToCSV());
        ReadAndWriteFile.writeToFile("test_final/data/xeTuanTra.csv",carMoonList,APPEND);

    }

    @Override
    public CarMoon findCarMoonByCode(String code) {
        List<CarMoon> listCarMoon = findAllCarMoon();
        for (CarMoon carMoon : listCarMoon) {
            if (carMoon.getCode().equals(code)) {
                return carMoon;
            }
        }
        return null;
    }

    @Override
    public void deleteCarMoonByCode(String code) {
        List<CarMoon> listCarMoon = findAllCarMoon();
        listCarMoon.removeIf(carMoon -> carMoon.getCode().equals(code));
        saveAllCarMoon(listCarMoon);
    }

    @Override
    public boolean isExistCarMoon(String code) {
        List<CarMoon> carMoons = findAllCarMoon();
        for (CarMoon carMoon : carMoons) {
            if (carMoon.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    private void saveAllCarMoon(List<CarMoon> listCarMoon) {
        List<String> stringList = new ArrayList<>();
        for (CarMoon carMoon : listCarMoon) {
            stringList.add(carMoon.getInfoToCSV());
        }
        ReadAndWriteFile.writeToFile("test_final/data/xeTuanTra.csv",stringList,false);
    }
}
