package com.sayed.example.restfulwebsevices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Avinash", new Date()));
		users.add(new User(2, "Avneet", new Date()));
		users.add(new User(3, "Ajay", new Date()));

	}

	public static List<User> findAll() {
		return users;
	}

	public static User save(User user) {
		if (user.getId() == null) {
			user.setId(users.size() + 1);
		}

		users.add(user);
		return user;
	}

	public static User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
