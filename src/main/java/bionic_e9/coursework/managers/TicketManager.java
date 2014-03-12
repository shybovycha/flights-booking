package bionic_e9.coursework.managers;

import java.util.List;
import java.util.TreeMap;

import bionic_e9.coursework.dao.FlightDAO;
import bionic_e9.coursework.dao.TicketDAO;
import bionic_e9.coursework.entities.*;

public class TicketManager {
	public static List<Ticket> all() {
		return TicketDAO.all();
	}
	
	public static Ticket create() {
		Ticket t = new Ticket();
		TicketDAO.save(t);
		return t;
	}
	
	public static void addFreeTickets(int flightId, int amount) {
		Flight flight = FlightDAO.find(flightId);
				
		for (int i = 0; i < amount; i++) {
			Ticket t = new Ticket();
			t.setFlight(flight);
			TicketDAO.save(t);
		}
	}
	
	public static int bookTickets(List<Ticket> tickets, Owner owner) {
		int counter = 0;
		
		for (Ticket t : tickets) {
			if (t.isAvailable()) {
				t.makeBooked(owner);
				TicketDAO.save(t);
				counter++;
			}
		}
		
		return counter;
	}
	
	public static int removeOutdatedOrders() {
		List<Ticket> tickets = TicketDAO.outdated();
		
		for (Ticket t : tickets) {
			t.makeAvailable();
			TicketDAO.save(t);
		}
		
		return tickets.size();
	}
	
	public static List<Ticket> orderedTickets() {
		return TicketDAO.ordered();
	}
	
	public static int sell(List<Ticket> tickets) {
		int counter = 0;
		
		for (Ticket t : tickets) {
			if (t.isBooked()) {
				t.makeSold();
				TicketDAO.save(t);
				counter++;
			}
		}
		
		return counter;
	}
	
	public static TreeMap<String, Float> soldReport(String dateFrom, String dateTo) {
		return TicketDAO.soldReportData(dateFrom, dateTo);
	}
}
