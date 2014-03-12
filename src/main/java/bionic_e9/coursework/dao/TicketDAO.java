package bionic_e9.coursework.dao;

import bionic_e9.coursework.entities.*;

public class TicketDAO extends BaseDAO {
	public static Ticket find(int id) {
		return find(Ticket.class, id);
	}
}
