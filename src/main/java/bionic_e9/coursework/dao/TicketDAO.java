package bionic_e9.coursework.dao;

import java.util.List;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import bionic_e9.coursework.entities.*;

public class TicketDAO extends BaseDAO {
	public static Ticket find(int id) {
		return find(Ticket.class, id);
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
	
	public static List<Ticket> sold() {
		String query = "SELECT Ticket t WHERE t.status = 'SOLD' AND t.owner IS NOT NULL";
		
		return TicketDAO.query(Ticket.class, query);
	}
	
	public static TreeMap<String, Float> soldReportData(String from, String to) {
		String query = String.format(
				"SELECT date, SUM(cost) FROM (" +
						"SELECT t.owner.ownerFrom AS date, f.ticketCost AS cost FROM Ticket t JOIN t.flight f" +
						"WHERE t.status = 'SOLD' AND t.owner IS NOT NULL AND t.owner.ownerFrom BETWEEN %s and %s" +
						"GROUP BY date" +
				")",
				from, to);
		
		EntityManager entityManager = getEntityManager();
		TypedQuery<Object[]> q = entityManager.createQuery(query, Object[].class);
		List<Object[]> resultList = q.getResultList();
		
		TreeMap<String, Float> resultMap = new TreeMap<String, Float>();
		
		for (Object[] fields : resultList) {
			String date = (String) fields[0];
			Float sum = (Float) fields[1];
			resultMap.put(date, sum);
		}
		
		return resultMap;
	}
}
