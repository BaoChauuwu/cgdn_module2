package test_final.model.entity;

public abstract class Vehicle {
    private String code;
    private String nameManufacturer;
    private String year;
    private String namePerson;

    public Vehicle(String code, String nameManufacturer, String year, String namePerson) {
        this.code = code;
        this.nameManufacturer = nameManufacturer;
        this.year = year;
        this.namePerson = namePerson;
    }

    public Vehicle() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public abstract String getInfoToCSV();

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", nameManufacturer='" + nameManufacturer + '\'' +
                ", year='" + year + '\'' +
                ", namePerson='" + namePerson + '\'' ;
    }
}
