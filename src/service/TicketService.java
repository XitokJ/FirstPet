package service;

import model.Ticket;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class TicketService {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public void bookTicket(Ticket ticket, Scanner scanner)
    {
        ticket.setId(IdGenerator.nextId());
        System.out.println("Введите название");

    }
}
