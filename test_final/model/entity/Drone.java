package test_final.model.entity;

public class Drone extends  Vehicle {
    private Double flyStreet;

    public Drone(String code, String nameManufacturer, String year, String namePerson, Double flyStreet) {
        super(code, nameManufacturer, year, namePerson);
        this.flyStreet = flyStreet;
    }

    public Drone(Double flyStreet) {
        this.flyStreet = flyStreet;
    }

    public Double getFlyStreet() {
        return flyStreet;
    }

    public void setFlyStreet(Double flyStreet) {
        this.flyStreet = flyStreet;
    }

    @Override
    public String getInfoToCSV() {
        return this.getCode() + ", " + this.getNameManufacturer() + ", " + this.getYear() + ", " + this.getNamePerson() + ", " + this.getFlyStreet();
    }

    @Override
    public String toString() {
        return "Drone" + super.toString() +
                ','+
                "flyStreet=" + flyStreet +
                '}';
    }
}
