package service;

import model.Flight;
import model.Ticket;

import javax.xml.transform.Source;
import java.io.*;
import java.util.ArrayList;

public class FileService {

    public void saveFlightToFile(ArrayList<Flight> flights) throws FileNotFoundException {
        try(ObjectOutputStream ofs = new ObjectOutputStream(new FileOutputStream("Flight.txt")))
        {
                ofs.writeObject(flights);
            System.out.println("Данные успешно записаны!");
        } catch (IOException e) {
            System.out.println("Не удалось сохранить данные, ошибка: " + e.getMessage());
        }
    }

    public ArrayList<Flight> loadFlightsFromFile(){
        try(ObjectInputStream ifs = new ObjectInputStream(new FileInputStream("Flight.txt")))
        {
            return (ArrayList<Flight>)ifs.readObject();
        } catch (IOException e) {
            System.out.println("Файл не найден, создается новый список рейсов...");
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось загрузить данные,ошибка: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public void saveTicketToFile(ArrayList<Ticket> tickets)
    {
        try(ObjectOutputStream ots = new ObjectOutputStream(new FileOutputStream("Ticket.txt")))
        {
            ots.writeObject(tickets);
            System.out.println("Данные успешно о билетах успешно записаны!");
        }
        catch (Exception e)
        {
            System.out.println("Ошибка загрузки данных о билете: " + e.getMessage());
        }
    }

    public ArrayList<Ticket> loadTicketFromFile()
    {
        try(ObjectInputStream its = new ObjectInputStream(new FileInputStream("Ticket.txt")))
        {
            return (ArrayList<Ticket>)its.readObject();
        }
        catch (Exception e)
        {
            System.out.println("Файл не найден, создается новый список билетов...");
        }
        return new ArrayList<>();
    }



}
