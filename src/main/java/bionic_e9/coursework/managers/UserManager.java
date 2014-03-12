package bionic_e9.coursework.managers;

import bionic_e9.coursework.dao.UserDAO;
import bionic_e9.coursework.entities.*;

import java.util.List;

public abstract class UserManager {
	public static List<User> all() {
		return UserDAO.all();
	}
	
	public static void destroy(int id) {
		UserDAO.destroy(id);
	}
	
	public static User update(int id, String username, String password, String role) {
		User user = UserDAO.find(id);
		
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		
		UserDAO.save(user);
		
		return user;
	}
	
	public static User create(String username, String password, String role) {
		User user = new User(username, password, role);
		UserDAO.save(user);
		
		return user;
	}
}
