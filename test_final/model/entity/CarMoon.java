package test_final.model.entity;

public class CarMoon extends Vehicle {
    private String levelSafe;

    public CarMoon(String code, String nameManufacturer, String year, String namePerson, String levelSafe) {
        super(code, nameManufacturer, year, namePerson);
        this.levelSafe = levelSafe;
    }

    public CarMoon(String levelSafe) {
        this.levelSafe = levelSafe;
    }

    public String getLevelSafe() {
        return levelSafe;
    }

    public void setLevelSafe(String levelSafe) {
        this.levelSafe = levelSafe;
    }

    @Override
    public String getInfoToCSV() {
        return this.getCode() + ", " + this.getNameManufacturer() + ", " + this.getYear() + ", " + this.getNamePerson() + ", " + this.getLevelSafe();
    }

    @Override
    public String toString() {
        return "CarMoon" +
                super.toString() +
                ','+
                "levelSafe='" + levelSafe + '\'' +
                '}';
    }
}
