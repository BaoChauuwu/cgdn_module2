package oop_bai_tap.entity;

public class Car extends Vehicle{
    private int seatCount;
    private String carType;

    public Car() {
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
                "seatCount=" + seatCount +
                ", carType='" + carType + '\'' +
                '}';
    }
}
