package oop_bai_tap.entity;

public  class Vehicle {
    private String licensePlate;
    private String manufacturerName;
    private int manufactureYear;
    private String ownerName;

    public Vehicle() {
    }

    public Vehicle(String licensePlate, String manufacturerName, int manufactureYear, String ownerName) {
        this.licensePlate = licensePlate;
        this.manufacturerName = manufacturerName;
        this.manufactureYear = manufactureYear;
        this.ownerName = ownerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
