package service;

import model.Flight;
import model.Passenger;
import model.Ticket;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketService {

    private ArrayList<Ticket> tickets;

    public TicketService() {
        tickets = new ArrayList<>();
    }

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
                    return;
                }
            }
            System.out.println("Вы забронировали: " + seatNumber +" место");
            ticket = new Ticket(IdGenerator.nextIdForTicket(),passenger.getID(), flight.getId(),seatNumber);
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            tickets.add(ticket);
        }
    }
    public void cancelTicket(Flight flight, Passenger passenger)
    {
        for(Ticket ticket: tickets)
        {
            if (ticket.getPassengerId() == passenger.getID() && ticket.getFlightId() == flight.getId())
            {
                System.out.println("Вы отменили билет");
                flight.setAvailableSeats(flight.getAvailableSeats() + 1);
                tickets.remove(ticket);
                return;
            }
        }
        System.out.println("У вас нет такого билета");
    }

    public void showPassengerTickets(Passenger passenger)
    {
        for(Ticket ticket: tickets)
        {
            if (passenger.getID() == ticket.getPassengerId())
                System.out.println("Ваш билет: " + ticket);
        }
    }

    public void checkFreeTickets(Flight flight)
    {
        List<Ticket> newTicketList = new ArrayList<>();
        for(Ticket ticket: tickets)
        {
            if (flight.getId() == ticket.getFlightId())
                newTicketList.add(ticket);
        }
        if ((newTicketList.size() - flight.getAvailableSeats()) == 0)
            System.out.println("Свободных мест нет");
        else
        {
            int freeSeats = flight.getAvailableSeats() - newTicketList.size();
            System.out.println("Свободных мест: " + freeSeats);
        }
    }

}
