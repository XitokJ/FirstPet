package menu;

import Exceptions.NoSeatsException;
import model.Flight;
import model.Passenger;
import service.FileService;
import service.FlightService;
import service.TicketService;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleMenu {

    public static void run(Scanner scanner,
                           FlightService flightService,
                           TicketService ticketService,
                           FileService fileService,
                           Passenger passenger) throws NoSeatsException {

        while (true) {
            System.out.println("\n===== МЕНЮ АВИАСИСТЕМЫ =====");
            System.out.println("1. Добавить рейс");
            System.out.println("2. Удалить рейс");
            System.out.println("3. Показать все рейсы");
            System.out.println("4. Поиск рейсов по городу прибытия");
            System.out.println("5. Сортировать рейсы по цене");
            System.out.println("6. Забронировать билет");
            System.out.println("7. Отменить билет");
            System.out.println("8. Показать мои билеты");
            System.out.println("9. Проверить количество свободных мест");
            System.out.println("10. Сохранить данные");
            System.out.println("11. Загрузить данные");
            System.out.println("0. Выход");
            System.out.print("Введите номер операции: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    flightService.addFlight(scanner);
                    System.out.println("Рейс успешно добавлен!");
                }
                case "2" -> flightService.removeFlight(scanner);
                case "3" -> flightService.showFlights();
                case "4" -> {
                    System.out.print("Введите город прибытия: ");
                    flightService.searchFlightsForCityArrivel(scanner);
                }
                case "5" -> flightService.sortFlights();
                case "6" -> {
                    flightService.showFlights();
                    System.out.print("Введите ID рейса для бронирования: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера

                    Flight selectedFlight = getFlightById(flightService, id);
                    if (selectedFlight != null) {
                        try {
                            ticketService.bookTicket(selectedFlight, passenger, scanner);
                        } catch (NoSeatsException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Рейс с таким ID не найден.");
                    }
                }
                case "7" -> {
                    flightService.showFlights();
                    System.out.print("Введите ID рейса для отмены: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Flight selectedFlight = getFlightById(flightService, id);
                    if (selectedFlight != null) {
                        ticketService.cancelTicket(selectedFlight, passenger);
                    } else {
                        System.out.println("Рейс не найден.");
                    }
                }
                case "8" -> ticketService.showPassengerTickets(passenger);
                case "9" -> {
                    flightService.showFlights();
                    System.out.print("Введите ID рейса: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Flight selectedFlight = getFlightById(flightService, id);
                    if (selectedFlight != null) {
                        ticketService.checkFreeTickets(selectedFlight);
                    } else {
                        System.out.println("Рейс не найден.");
                    }
                }
                case "10" -> {
                    try {
                        fileService.saveFlightToFile(flightService.getFlights());
                        fileService.saveTicketToFile(ticketService.getTickets());
                    } catch (NoSeatsException | FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "11" -> {
                    flightService.setFlights(fileService.loadFlightsFromFile());
                    ticketService.setTickets(fileService.loadTicketFromFile());
                    System.out.println("Данные успешно загружены!");
                }
                case "0" -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Неверный пункт меню! Попробуйте снова.");
            }
        }
    }

    private static Flight getFlightById(FlightService flightService, int id) {
        for (Flight flight : flightService.getFlights()) {
            if (flight.getId() == id) return flight;
        }
        return null;
    }
}
