package oop_bai_tap.repository;

import oop_bai_tap.entity.Car;
import oop_bai_tap.entity.Motobike;
import oop_bai_tap.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class MotobikeRepository implements IMotobikeRepository {

    @Override
    public List<Motobike> findAll() {
        List<Motobike> motobikeList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFromFile("oop_bai_tap/data/motobike.csv");
        String[] array = null;
        for (String string : stringList) {
            array = string.split(",");
            Motobike motobike = new Motobike(array[0], array[1], Integer.parseInt(array[2]), array[3], Double.parseDouble(array[4]));
            motobikeList.add(motobike);
        }
        return motobikeList;
    }

    @Override
    public void addMotobikeToCar(Car car) {

    }

    @Override
    public boolean deleteMotobikeFromCar(Car car) {
        return false;
    }

    @Override
    public void addMotobike(Motobike motobike) {
        List<Motobike> motobikeList = getListMotobike();
        motobikeList.add(motobike);
        List<String> stringList = new ArrayList<>();
        for (Motobike mb : motobikeList) {
            stringList.add(mb.getLicensePlate() + "," + mb.getManufacturerName() + "," + mb.getManufactureYear() + "," + mb.getOwnerName() + "," + mb.getHorsePower());
        }
        ReadAndWriteFile.writeToFile("oop_bai_tap/data/motobike.csv", stringList, false);
    }

    @Override
    public List<Motobike> getListMotobike() {
        return findAll();
    }
}

