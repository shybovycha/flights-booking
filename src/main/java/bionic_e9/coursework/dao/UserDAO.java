package bionic_e9.coursework.dao;

import java.util.List;

import bionic_e9.coursework.entities.*;

public class UserDAO extends BaseDAO {
	public static User find(int id) {
		return find(User.class, id);
	}
	
	public static List<User> all() {
		return all(User.class);
	}
	
	public static void destroy(int id) {
		destroy(User.class, id);
	}
}
