package bionic_e9.coursework.entities;

import javax.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="flights")
public class Flight extends AbstractEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String departure;
	private String destination;
	private java.sql.Date date;
	private float ticketCost;
	
	@OneToMany(mappedBy="flight", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	public Flight() {
	}
	
	public Flight(String departure, String destination, Date date, float ticketCost) {
		this.departure = departure;
		this.destination = destination;
		this.date = date;
		this.ticketCost = ticketCost;
	}

	@Override
	public String toString() {
		return String.format("From: %s; To: %s; At: %s; Ticket cost: %.2f", 
				this.getDeparture(), this.getDestination(), 
				this.getDate(), this.getTicketCost());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(float ticketCost) {
		this.ticketCost = ticketCost;
	}

	public int getTicketsAmount() {
		return tickets.size();
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}
