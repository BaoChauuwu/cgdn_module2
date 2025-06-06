package oop_bai_tap.entity;

public class Truck extends Vehicle{
    private double loadCapacity;

    public Truck(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Truck(String licensePlate, String manufacturerName, int manufactureYear, String ownerName, double loadCapacity) {
        super(licensePlate, manufacturerName, manufactureYear, ownerName);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "loadCapacity=" + loadCapacity +
                '}';
    }
}
