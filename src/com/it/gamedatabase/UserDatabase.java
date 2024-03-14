package com.it.gamedatabase;

import java.util.HashMap;

public class UserDatabase {

	private static final HashMap<String, String> users = new HashMap<>();

	static {

		users.put("admin", "admin1234");
		users.put("guest", "guest1234");
	}

	public static boolean isValidUser(String username, String password) {
		return users.containsKey(username) && users.get(username).equals(password);
	}
}
