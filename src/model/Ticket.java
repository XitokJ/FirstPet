package model;

import java.io.Serializable;
import java.util.Objects;

public class Ticket implements Serializable {
    private int id;
    private int flightId;
    private int passengerId;
    private int seatNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && flightId == ticket.flightId && passengerId == ticket.passengerId && seatNumber == ticket.seatNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, passengerId, seatNumber);
    }

    public Ticket(int id, int flightId, int passengerId, int seatNumber) {
        this.id = id;
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.seatNumber = seatNumber;
    }
    public Ticket(int flightId,int passengerId, int seatNumber)
    {
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.seatNumber = seatNumber;
    }
    public String toString()
    {
        return "Ваш билет: id- " + id + "flightId- " + flightId + "passengerId- " + passengerId + "seatNumber- " + seatNumber;
    }
}
