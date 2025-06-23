package oop_bai_tap.entity;

public class Car extends Vehicle{
    private int seatCount;
    private String carType;

    public Car() {
    }
//    private String licensePlate;
//    private String manufacturerName;
//    private int manufactureYear;
//    private String ownerName;
    @Override
    public String getInfoToCSV() {
        return this.getLicensePlate()+","+this.getManufacturerName()+","+this.getManufactureYear()+","+this.getOwnerName()+","+this.getSeatCount()+","+this.getCarType();
    }


    public Car(int seatCount, String carType) {
        this.seatCount = seatCount;
        this.carType = carType;
    }

    public Car(String licensePlate, String manufacturerName, int manufactureYear, String ownerName, int seatCount, String carType) {
        super(licensePlate, manufacturerName, manufactureYear, ownerName);
        this.seatCount = seatCount;
        this.carType = carType;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                "seatCount=" + seatCount +
                ", carType='" + carType + '\'' +
                '}';
    }
}
