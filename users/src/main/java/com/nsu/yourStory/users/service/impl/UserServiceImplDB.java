package com.nsu.yourStory.users.service.impl;

import com.nsu.yourStory.users.model.User;
import com.nsu.yourStory.users.repository.UserRepository;
import com.nsu.yourStory.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplDB implements UserService {

	@Autowired
	private UserRepository userDao;

	@Override
	public Optional<User> readUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

	@Override
	public Optional<User> readUserByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}

	@Override
	public User updateUser(User user) {
		return null;
	}
}
