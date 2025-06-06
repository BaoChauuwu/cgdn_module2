package oop_bai_tap.repository;

import oop_bai_tap.entity.Truck;

import java.util.ArrayList;
import java.util.List;

public class TrucRepository {
    List<Truck> listTrucks = new ArrayList<>();
    public TrucRepository() {
        listTrucks.add(new Truck("43C-012.34", "Huyndai", 2019, "Nguyễn Văn A", 3));
        listTrucks.add(new Truck("43C-47.678","Dongfeng",2020,"Nguyễn Văn B",9));
        listTrucks.add(new Truck("43C-45.235","Hino",2021,"Nguyễn Văn C",12));
    }
    public void  addTruck(Truck truck){
        listTrucks.add(truck);
    }
    public List<Truck> getTrucks(){
        return listTrucks;
    }
    public void findTruckByLicensePlate(String licensePlate){
        listTrucks.removeIf(truck -> truck.getLicensePlate().equals(licensePlate));
    }
}
