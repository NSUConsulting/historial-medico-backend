package com.nsu.yourStory.users.service;

import com.nsu.yourStory.users.model.User;

import java.util.Optional;

public interface UserService {
	Optional<User> readUserByEmail(String username);
	Optional<User> readUserByUuid(String uuid);

	User updateUser(User user);
}
