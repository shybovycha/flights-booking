package bionic_e9.coursework.managers;

import bionic_e9.coursework.entities.*;
import java.util.List;
import java.util.TreeMap;

public interface IUserManager {
	public List<User> all();
	public void destroy(int id);
	public User update(int id, String username, String password, String role);
	public User create(String username, String password, String role);
}
