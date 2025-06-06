package oop_bai_tap.service;

import oop_bai_tap.entity.Truck;
import oop_bai_tap.repository.TrucRepository;

import java.util.List;

public class TruckService implements ITruckService {
    TrucRepository trucRepository = new TrucRepository();
    @Override
    public void addTruck(Truck truck) {
        trucRepository.addTruck(truck);
    }

    @Override
    public List<Truck> getTrucks() {
        return trucRepository.getTrucks();
    }
}
