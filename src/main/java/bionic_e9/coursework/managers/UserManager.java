package bionic_e9.coursework.managers;

import bionic_e9.coursework.entities.*;
import java.util.List;
import java.util.TreeMap;

public abstract class UserManager {
	public abstract List<User> all();
	public abstract void destroy(int id);
	public abstract User update(int id, String username, String password, String role);
	public abstract User create(String username, String password, String role);
}
