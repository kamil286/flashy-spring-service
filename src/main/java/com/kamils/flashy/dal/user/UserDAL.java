package com.kamils.flashy.dal.user;

import java.util.List;

import com.kamils.flashy.model.User;

public interface UserDAL {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	void deleteUser(String userId);

	void updateUser(String userId, String name);

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);
}