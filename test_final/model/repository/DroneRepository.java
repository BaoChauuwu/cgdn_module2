package test_final.model.repository;

import test_final.model.entity.Drone;
import test_final.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class DroneRepository implements IDroneRepository {
    private final boolean APPEND = true;
    @Override
    public List<Drone> findAllDrone() {
     List<Drone> listDrone = new ArrayList<>();
     List<String> stringList = ReadAndWriteFile.readFromFile("test_final/data/drone.csv");
     String[] array = null;
     for(String string : stringList){
         array = string.split(",");
         Drone drone = new Drone(array[0],array[1],array[2],array[3],Double.parseDouble(array[4]));
         listDrone.add(drone);
     }
     return listDrone;
    }

    @Override
    public void addDrone(Drone drone) {
        List<String> listDrone= new ArrayList<>();
        listDrone.add(drone.getInfoToCSV());
        ReadAndWriteFile.writeToFile("test_final/data/drone.csv",listDrone,APPEND);
    }

    @Override
    public Drone findDroneByCode(String code) {
        List<Drone> listDrone = findAllDrone();
        for(Drone drone : listDrone){
            if (drone.getCode().equals(code)){
                return drone;
            }
        }
        return null;
    }

    @Override
    public void deleteDroneByCode(String code) {
        List<Drone> listDrone = findAllDrone();
        listDrone.removeIf(drone -> drone.getCode().equals(code));
        saveAllDrones(listDrone);
    }

    @Override
    public boolean isExistDroneCode(String code) {
        List<Drone> allDrone = findAllDrone();
        for (Drone drone : allDrone) {
            if (drone.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    private void saveAllDrones( List<Drone> listDrone){
        List<String> stringList = new ArrayList<>();
        for (Drone drone : listDrone){
            stringList.add(drone.getInfoToCSV());
        }
        ReadAndWriteFile.writeToFile("test_final/data/drone.csv",stringList,false);
    }
}

