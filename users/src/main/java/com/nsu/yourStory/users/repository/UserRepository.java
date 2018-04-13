package com.nsu.yourStory.users.repository;

import com.nsu.yourStory.users.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends LogicalDeleteableDao<User> {
	Optional<User> findUserByEmail(String email);
}
