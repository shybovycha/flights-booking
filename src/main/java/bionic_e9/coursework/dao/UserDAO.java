package bionic_e9.coursework.dao;

import bionic_e9.coursework.entities.*;

public class UserDAO extends BaseDAO {
	public static User find(int id) {
		return find(User.class, id);
	}
}
