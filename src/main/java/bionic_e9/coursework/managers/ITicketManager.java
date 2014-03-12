package bionic_e9.coursework.managers;

import java.util.List;
import java.util.TreeMap;

import bionic_e9.coursework.entities.*;

public interface ITicketManager {
	public int bookTickets(List<Ticket> tickets, Owner owner);
	public int removeOutdatedOrders();
	public List<Ticket> orderedTickets();
	public int sell(List<Ticket> tickets);
	public TreeMap<String, Float> soldReport(String dateFrom, String dateTo);
}
