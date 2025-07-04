package final_module2.model.entity;

public  class Contact {
    private String userName;
    private String number;
    private String address;
    private String email;
    private String group;
    private String sex;
    private String dob;

    public Contact(String userName, String number, String address, String email, String group, String sex, String dob) {
        this.userName = userName;
        this.number = number;
        this.address = address;
        this.email = email;
        this.group = group;
        this.sex = sex;
        this.dob = dob;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getInfoToCSV(){
        return this.getUserName()+","+this.getNumber()+","+this.getAddress()+","+this.getEmail()+","+this.getGroup()+","+this.getSex()+","+this.getDob();
    }

    @Override
    public String toString() {
        return "Contact{" +
                "userName='" + userName + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                ", sex='" + sex + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
