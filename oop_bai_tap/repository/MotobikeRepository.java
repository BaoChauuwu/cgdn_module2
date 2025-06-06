package oop_bai_tap.repository;

import oop_bai_tap.entity.Car;
import oop_bai_tap.entity.Motobike;

import java.util.ArrayList;
import java.util.List;

public class MotobikeRepository {
    List<Motobike> listMotobike = new ArrayList<Motobike>();

    public MotobikeRepository() {
        listMotobike.add(new Motobike("43-K1-678.56","Yamaha",2019,"Nguyễn Văn A",100));
        listMotobike.add(new Motobike("43-H1-345.89","Honda",2019,"Nguyễn Văn B",150));
        listMotobike.add(new Motobike("43-AK-765.23","Yamaha",2019,"Nguyễn Văn C",50));
    }
    public void addMotobike(Motobike motobike) {
        listMotobike.add(motobike);
    }


    public List<Motobike> getListMotobike() {
        return listMotobike;
    }

    public void findMotobikeByLicensePlate(String licensePlate){
        listMotobike.removeIf(m -> m.getLicensePlate().equals(licensePlate));
    }
}

