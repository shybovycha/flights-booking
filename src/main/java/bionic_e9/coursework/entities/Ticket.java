package bionic_e9.coursework.entities;

import javax.persistence.*;

@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Embedded
	private Owner owner;
	private int orderedAmount;
	
	@ManyToOne
	@JoinColumn(name="flightId")
	private Flight flight;
	
	private boolean selled;
	
	public Ticket() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public int getOrderedAmount() {
		return orderedAmount;
	}

	public void setOrderedAmount(int orderedAmount) {
		this.orderedAmount = orderedAmount;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public boolean isSelled() {
		return selled;
	}

	public void setSelled(boolean selled) {
		this.selled = selled;
	}
}
