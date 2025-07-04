package test_final.model.service;

import test_final.model.entity.Drone;
import test_final.model.repository.DroneRepository;
import test_final.model.repository.IDroneRepository;

import java.util.List;

public class DroneService implements IDroneService {
    private IDroneRepository droneRepository = new DroneRepository();
    
    @Override
    public List<Drone> findAllDrone() {
        return droneRepository.findAllDrone();
    }

    @Override
    public void addDrone(Drone drone) {
        if (drone != null && !isExistDroneCode(drone.getCode())) {
            droneRepository.addDrone(drone);
        } else {
            System.out.println("Drone đã tồn tại");
        }
    }

    @Override
    public Drone findDroneByCode(String code) {
        return droneRepository.findDroneByCode(code);
    }

    @Override
    public void deleteDroneByCode(String code) {
        if (droneRepository.findDroneByCode(code) != null) {
            droneRepository.deleteDroneByCode(code);
        } else {
            System.out.println("Drone not found");
        }
    }

    @Override
    public boolean isExistDroneCode(String code) {
       return droneRepository.isExistDroneCode(code);
    }
    
    public Drone findDroneByNamePerson(String namePerson) {
        List<Drone> allDrones = findAllDrone();
        for (Drone drone : allDrones) {
            if (drone.getNamePerson().equalsIgnoreCase(namePerson)) {
                return drone;
            }
        }
        return null;
    }
}
