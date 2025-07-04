package test_final.model.service;

import test_final.model.entity.Drone;

import java.util.List;

public interface IDroneService {
    List<Drone> findAllDrone();
    void addDrone(Drone drone);
    Drone findDroneByCode(String code);
    void deleteDroneByCode(String code);
    boolean isExistDroneCode(String code);
}
