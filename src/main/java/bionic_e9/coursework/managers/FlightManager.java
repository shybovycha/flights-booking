package bionic_e9.coursework.managers;

import java.util.List;

import bionic_e9.coursework.dao.*;
import bionic_e9.coursework.entities.*;

public class FlightManager {
	public static List<Flight> all() {
		return FlightDAO.all();
	}
	
	public static List<Flight> findFlights(String to, String when) {
		return FlightDAO.find(to, BaseDAO.str2date(when));
	}
	
	public static List<Flight> findFlights(String to, String fromDate, String toDate) {
		return FlightDAO.find(to, BaseDAO.str2date(fromDate), BaseDAO.str2date(toDate));
	}
	
	public static Flight create(String from, String to, String date, double ticketCost) {
		Flight f = FlightDAO.create(from, to, date, ticketCost);
		FlightDAO.save(f);
		return f;
	}
	
	public static Flight update(int id, String from, String to, String date, float ticketCost) {
		Flight f = FlightDAO.find(id);
		f.setDeparture(from);
		f.setDestination(to);
		f.setDate(BaseDAO.str2date(date));
		f.setTicketCost(ticketCost);
		FlightDAO.save(f);
		return f;
	}
	
	public static void destroy(int id) {
		FlightDAO.destroy(id);
	}
}
