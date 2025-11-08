package service;

import model.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightService {

    private ArrayList<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Id рейса: ");
        for(Flight flight1: flights)
        {
            if(flights.contains(scanner.nextInt())){
                System.out.println("Данный id уже занят!");
            }
        }
        flight.setId(scanner.nextInt());
    }



}
