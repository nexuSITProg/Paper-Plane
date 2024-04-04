package db;

public class Passenger {
    private int id;
    private int passportSeries;
    private int passportNumber;
    private String secondName;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private int raceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    @Override
    public String toString() {
        return "Passenger " + id + ": {\n" +
                "passport series: " + passportSeries + "\n" +
                "passport number: " + passportNumber + "\n" +
                "second name: " + secondName + "\n" +
                "first name: " + firstName + "\n" +
                "last name: " + lastName + "\n" +
                "address: " + address + "\n" +
                "phone: 8" + phone + "\n" +
                "race id: " + raceId +
                " }";
    }
}
