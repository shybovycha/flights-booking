package bionic_e9.coursework.managers;

import java.util.List;

import bionic_e9.coursework.dao.*;
import bionic_e9.coursework.entities.*;

public interface IFlightManager {
	public List<Flight> all();
	public List<Flight> findFlights(String to, String when);
	public List<Flight> findFlights(String to, String fromDate, String toDate);
	public Flight create(String from, String to, String date, float ticketCost);
	public Flight update(int id, String from, String to, String date, float ticketCost);
	public void destroy(int id);
}
