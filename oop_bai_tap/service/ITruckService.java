package oop_bai_tap.service;

import oop_bai_tap.entity.Truck;

import java.util.List;

public interface ITruckService {
     void addTruck(Truck truck);
     List<Truck> getTrucks();
}
