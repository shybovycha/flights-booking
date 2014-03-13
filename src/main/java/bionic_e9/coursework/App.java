package bionic_e9.coursework;

import java.util.List;

import bionic_e9.coursework.managers.*;
import bionic_e9.coursework.entities.*;

public class App {
	public static void seed() {
		TicketManager.destroyAll();
		FlightManager.destroyAll();
		UserManager.destroyAll();
		
		Flight f1 = FlightManager.create("Kyiv", "Minsk", "01/04/2014", 175.12);
		Flight f2 = FlightManager.create("Stockholm", "Moscow", "15/04/2014", 15.99);
		Flight f3 = FlightManager.create("Kyiv", "Amsterdam", "12/04/2014", 1576.34);
		Flight f4 = FlightManager.create("San Hose", "Kyiv", "12/04/2014", 6.34);
		
		TicketManager.addFreeTickets(f1, 5);
		TicketManager.addFreeTickets(f2, 15);
		TicketManager.addFreeTickets(f3, 35);
		TicketManager.addFreeTickets(f4, 12);
		
		Owner o1 = new Owner("Jane Doe", "12345", "Earth, 9th district", "jane@doe.com");
		Owner o2 = new Owner("Jed Lee", "123-45-67", "China", "jed@lee.com");
		Owner o3 = new Owner("Steven Seagul", "9415-21", "California", "steve@save-seaguls.com");
		Owner o4 = new Owner("Chuck Norris", "911", "The Universe", "chuck.norris@uni.verse");
		Owner o5 = new Owner("Nyan Cat", "182975918725", "The Milky Way", "nyan@nyan.nyan");
		
		TicketManager.bookTickets(f1, 2, o1);
		TicketManager.bookTickets(f2, 3, o2);
		TicketManager.bookTickets(f3, 1, o2);
		TicketManager.bookTickets(f4, 12, o3);
		
		TicketManager.bookTickets(f1, 1, o4);
		TicketManager.bookTickets(f2, 1, o4);
		TicketManager.bookTickets(f3, 1, o5);
		TicketManager.bookTickets(f4, 20, o5);
	}
	
    public static void main(String[] args) {
    	/*
    	 * TODO: add cool tests!
    	 */
    	seed();
    	
    	List<Flight> flights = FlightManager.all();
    	
    	for (Flight f : flights) {
    		System.out.printf("From: %s To: %s At: %s Tickets: %d Free: %d\n", 
    				f.getDeparture(), f.getDestination(), f.getDate(), 
    				f.getTickets().size(), TicketManager.free(f).size());
    	}
    }
}