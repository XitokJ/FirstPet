import Exceptions.NoSeatsException;
import menu.ConsoleMenu;
import model.Passenger;
import service.FileService;
import service.FlightService;
import service.TicketService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSeatsException {
            Scanner scanner = new Scanner(System.in);

            FlightService flightService = new FlightService();
            TicketService ticketService = new TicketService();
            FileService fileService = new FileService();

            // Можно создать одного пассажира (пока без авторизации)
            Passenger passenger = new Passenger(1, "Иван Иванов");

            ConsoleMenu.run(scanner, flightService, ticketService, fileService, passenger);

    }
}