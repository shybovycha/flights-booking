package bionic_e9.coursework;

import java.util.List;

import bionic_e9.coursework.managers.*;
import bionic_e9.coursework.entities.*;

public class App {
	public static void seed() {
		Flight f1 = FlightManager.create("Kyiv", "Minsk", "01/04/2014", 175.12);
		Flight f2 = FlightManager.create("Stockholm", "Moscow", "15/04/2014", 15.99);
		Flight f3 = FlightManager.create("Kyiv", "Amsterdam", "12/04/2014", 1576.34);
		Flight f4 = FlightManager.create("San Hose", "Kyiv", "12/04/2014", 6.34);
		
		TicketManager.addFreeTickets(f1.getId(), 5);
		TicketManager.addFreeTickets(f2.getId(), 15);
		TicketManager.addFreeTickets(f3.getId(), 35);
		TicketManager.addFreeTickets(f4.getId(), 12);
	}
	
    public static void main(String[] args) {
    	//seed();
    	//FlightManager.deleteEmpty();
    	
    	List<Flight> flights = FlightManager.all();
    	
    	for (Flight f : flights) {
    		System.out.printf("From: %s To: %s At: %s Tickets: %d\n", f.getDeparture(), f.getDestination(), f.getDate(), f.getTickets().size());
    	}
    }
}