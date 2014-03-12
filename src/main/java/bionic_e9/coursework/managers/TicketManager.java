package bionic_e9.coursework.managers;

import java.util.List;
import java.util.TreeMap;

import bionic_e9.coursework.entities.*;

public abstract class TicketManager {
	public abstract int bookTickets(List<Ticket> tickets, Owner owner);
	public abstract int removeOutdatedOrders();
	public abstract List<Ticket> orderedTickets();
	public abstract int sell(List<Ticket> tickets);
	public abstract TreeMap<String, Float> soldReport(String dateFrom, String dateTo);
}
