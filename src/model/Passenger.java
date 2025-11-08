package model;

public class Passenger
{

    private int ID;
    private String fullName;
    private String passportNumber;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


    public Passenger(int ID, String fullName, String passportNumber) {
        this.ID = ID;
        this.fullName = fullName;
        this.passportNumber = passportNumber;
    }
}
