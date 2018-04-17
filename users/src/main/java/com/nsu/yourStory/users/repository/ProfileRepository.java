package com.nsu.yourStory.users.repository;

import com.nsu.yourStory.users.model.Profile;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends LogicalDeleteableDao<Profile> {
}
