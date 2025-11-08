package model;

import java.util.Scanner;

public class Flight implements Comparable<Flight>
{
    private int id;
    private String departureCity;
    private String arrivalCity;
    private String dateTime;
    private int availableSeats;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Flight(int id, String departureCity, String arrivalCity, String dateTime, int availableSeats, double price) {
        this.id = id;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.dateTime = dateTime;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Flight o) {
        return Double.compare(this.price,o.price);
    }
}
