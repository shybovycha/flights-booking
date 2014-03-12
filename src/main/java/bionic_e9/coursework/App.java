package bionic_e9.coursework;

import java.util.List;

import bionic_e9.coursework.managers.*;
import bionic_e9.coursework.entities.*;

public class App {
    public static void main(String[] args) {
    	//Flight f = FlightDAO.create("kyiv", "minsk", "01/04/2014", 175.12);
    	//FlightDAO.save(f);
    	//List<Flight> f2 = FlightDAO.all(); //find("kyiv", BaseDAO.str2date("01/03/2014"), BaseDAO.str2date("02/04/2014"));
    	
    	//System.out.printf("Flights in DB: %d\n", f2.size()); //From: %s To: %s At: %s\n", f2.get(0).getDeparture(), f2.get(0).getDestination(), f2.get(0).getDate());
    	
    	FlightManager.create("Stockholm", "Moscow", "15/04/2013", 15.99);
    	
    	List<Flight> flights = FlightManager.all();
    	
    	for (Flight f : flights) {
    		System.out.printf("From: %s To: %s At: %s\n", f.getDeparture(), f.getDestination(), f.getDate());
    	}
    }
}