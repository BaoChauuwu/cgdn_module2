package test_casestudy.model.entity;

public abstract class Person {
    private String id;
    private String code;
    private String name;
    private String email;
    private String dateOfBirth;

    public Person(String id, String code, String name, String email, String dateOfBirth) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    public Person() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public abstract String getInfoToCSV();

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
