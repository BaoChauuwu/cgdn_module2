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
            Motobike motobike = new Motobike(array[0],array[1],Integer.parseInt(array[3]),array[4],Double.parseDouble(array[5]));
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
}

