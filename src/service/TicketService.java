package service;

import Exceptions.NoSeatsException;
import model.Flight;
import model.Passenger;
import model.Ticket;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TicketService {

    private ArrayList<Ticket> tickets;

    public TicketService() {
        tickets = new ArrayList<>();
    }

    public void bookTicket(Flight flight, Passenger passenger, Scanner scanner) throws NoSeatsException {
        if(flight.getAvailableSeats() == 0)
        {
            throw new NoSeatsException("На самолете нет больше мест :-( ");
        }

        if (flight.getAvailableSeats() > 0)
        {
            System.out.println("Введите номер места, которое хотите забронировать: ");
            int seatNumber = scanner.nextInt();
            if (seatNumber < 1 || seatNumber > flight.getMAX_SEATS())
            {
                throw new NoSeatsException("Неправильно выбрано место");
            }
            for (Ticket ticket1: tickets)
            {
                if (ticket1.getSeatNumber() == seatNumber && ticket1.getFlightId() == flight.getId())
                {
                    throw new NoSeatsException("Такое место занято");
                }
            }
            System.out.println("Вы забронировали: " + seatNumber +" место");
            Ticket ticket = new Ticket(IdGenerator.nextIdForTicket(),passenger.getID(), flight.getId(),seatNumber);
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            tickets.add(ticket);
        }
    }
    public void cancelTicket(Flight flight, Passenger passenger)
    {
        Iterator<Ticket> iterator = tickets.iterator();

        while(iterator.hasNext())
        {
            Ticket ticket = iterator.next();
            if (ticket.getPassengerId() == passenger.getID() && ticket.getFlightId() == flight.getId())
            {
                System.out.println("Вы отменили билет");
                flight.setAvailableSeats(flight.getAvailableSeats() + 1);
                iterator.remove();
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
        System.out.println("Кол-во мест на " + flight.getId() +"-рейсе: " + flight.getAvailableSeats());
    }

}
