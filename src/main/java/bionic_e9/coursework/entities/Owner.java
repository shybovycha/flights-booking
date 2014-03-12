package bionic_e9.coursework.entities;

import javax.persistence.*;

@Embeddable
@Access(AccessType.FIELD)
public class Owner {
	private String address;
	private String email;
	private String phone;
	private String name;
	
	public Owner() {
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
