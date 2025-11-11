package service;

import model.Flight;
import model.Passenger;
import model.Ticket;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class TicketService {

    ArrayList<Ticket> tickets = new ArrayList<>();

    public void bookTicket(Flight flight, Passenger passenger, Ticket ticket, Scanner scanner)
    {
        if (flight.getAvailableSeats() > 0)
        {
            int seatNumber = scanner.nextInt();
            for (Ticket ticket1: tickets)
            {
                if (ticket1.getSeatNumber() == seatNumber)
                {
                    System.out.println("Такое место занято");
                    break;
                }
                else
                {
                    System.out.println("Вы забронировали: " + seatNumber +" место");
                    ticket = new Ticket(IdGenerator.nextIdForTicket(),passenger.getID(), flight.getId(),seatNumber);
                    flight.setAvailableSeats(flight.getAvailableSeats() - 1);
                    tickets.add(ticket);
                    break;
                }
            }
        }
    }
}
