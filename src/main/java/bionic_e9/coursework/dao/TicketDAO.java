package bionic_e9.coursework.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import bionic_e9.coursework.entities.*;

public class TicketDAO extends BaseDAO {
	public static Ticket find(int id) {
		return find(Ticket.class, id);
	}
	
	public static void destroyAll() {
		destroyAll(Ticket.class);
	}
	
	public static List<Ticket> all() {
		return all(Ticket.class);
	}
	
	public static Owner createOwner(String name, String phone, String address, String email) {
		return new Owner(name, phone, address, email);
	}
	
	public static List<Ticket> outdated() {
		DateTimeFormatter df = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		String query = String.format("SELECT Ticket t WHERE t.owner.ownerFrom < %s AND t.status = 'BOOKED'",
				DateTime.now().minusDays(3).toString(df));
		
		return TicketDAO.query(Ticket.class, query);
	}
	
	public static List<Ticket> ordered() {
		String query = "SELECT Ticket t WHERE t.status = 'ORDERED' AND t.owner IS NOT NULL";
		
		return TicketDAO.query(Ticket.class, query);
	}
	
	public static List<Ticket> ordered(int flightId) {
		String query = String.format(
				"SELECT Ticket t JOIN Flight f WHERE t.status = 'ORDERED' AND t.owner IS NOT NULL AND f.id = %d",
				flightId);
		
		return TicketDAO.query(Ticket.class, query);
	}
	
	public static List<Ticket> free() {
		String query = "SELECT Ticket t WHERE t.status = 'ORDERED' AND t.owner IS NULL";
		
		return TicketDAO.query(Ticket.class, query);
	}
	
	public static List<Ticket> free(int flightId) {
		String query = String.format(
				"SELECT t FROM Ticket t JOIN t.flight f WHERE t.status = 'AVAILABLE' AND t.owner IS NULL AND f.id = %d",
				flightId);
		
		return TicketDAO.query(Ticket.class, query);
	}
	
	public static List<Ticket> free(Flight flight) {
		return free(flight.getId());
	}
	
	public static List<Ticket> sold() {
		String query = "SELECT Ticket t WHERE t.status = 'SOLD' AND t.owner IS NOT NULL";
		
		return TicketDAO.query(Ticket.class, query);
	}
	
	public static List<SoldReportRow> soldReportByDate(String from, String to) {
		String query = String.format(
			"SELECT NEW bionic_e9.coursework.entities.SoldReportLine(date, SUM(cost), COUNT(id)) FROM (" +
				"SELECT t.id, t.owner.ownerFrom AS date, f.ticketCost AS cost FROM Ticket t JOIN t.flight f" +
				"WHERE t.status = 'SOLD' AND t.owner IS NOT NULL AND t.owner.ownerFrom BETWEEN %s and %s" +
				"GROUP BY date" +
			")",
			from, to);
		
		return TicketDAO.query(SoldReportRow.class, query);
	}
	
	public static List<SoldReportRow> soldReportByDestination(String from, String to) {
		String query = String.format(
			"SELECT " +
				"NEW bionic_e9.coursework.entities.SoldReportLine(date, destination, SUM(cost), COUNT(id)) " +
			"FROM (" +
				"SELECT t.id AS id, t.owner.ownerFrom AS date, f.destination AS destination, f.ticketCost AS cost " +
				"FROM Ticket t JOIN t.flight f" +
				"WHERE t.status = 'SOLD' AND t.owner IS NOT NULL AND t.owner.ownerFrom BETWEEN %s and %s" +
				"GROUP BY date, destination" +
			")",
			from, to);
		
		return TicketDAO.query(SoldReportRow.class, query);
	}
}
