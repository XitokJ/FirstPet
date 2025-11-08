package service;

import model.Flight;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FlightService {

    private ArrayList<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight, Scanner scanner)
    {
        flight.setId(IdGenerator.nextId());
        System.out.println("Введите название города отправления: ");
        flight.setDepartureCity(scanner.nextLine());
        System.out.println("Введите название города прибытия: ");
        flight.setArrivalCity(scanner.nextLine());
        System.out.println("Введите дату прибытия(формат любой): ");
        flight.setDateTime(scanner.nextLine());
        System.out.println("Введите количество мест: ");
        int n = scanner.nextInt();
        while(n > 300)
        {
            System.out.println("Превышено допустимое кол-во мест(>300)! Введите новое число: ");
            n = scanner.nextInt();
        }
        flight.setAvailableSeats(n);
        System.out.println("Введите цену за билет: ");
        flight.setPrice(scanner.nextDouble());

        flights.add(flight);
    }

    public void removeFlight(Scanner scanner)
    {
        System.out.println("Введите Id для удаления: ");
        int id = scanner.nextInt();
        for (Flight flight: flights)
        {
            if(flight.getId() == id)
            {
                flights.remove(flight);
                break;
            }
        }
        {
            System.out.println("Такого рейса не существует");
        }
    }

    public void showFlights()
    {
        for(Flight flight: flights)
        {
            System.out.println(flight.toString());
        }
    }

    public void searchFlightsForCityArrivel(Scanner scanner)
    {
        String city = scanner.nextLine();
        System.out.println("Рейсы с вашим городом прибытия: ");
        for(Flight flight: flights)
        {
            if(flight.getArrivalCity().equals(city))
            {
                System.out.println(flight.toString());
            }
        }
    }


    public void sortFlights()
    {
        System.out.println("Произведена сортировка по цене!");
        flights.sort(null);
    }


}
