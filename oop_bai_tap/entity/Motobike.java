package oop_bai_tap.entity;

public class Motobike extends Vehicle {
    private double horsePower;

    public Motobike(double horsePower) {
        this.horsePower = horsePower;
    }

    public Motobike(String licensePlate, String manufacturerName, int manufactureYear, String ownerName, double horsePower) {
        super(licensePlate, manufacturerName, manufactureYear, ownerName);
        this.horsePower = horsePower;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Motobike{" +
                "horsePower=" + horsePower +
                '}';
    }
}
