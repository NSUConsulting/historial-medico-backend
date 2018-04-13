package com.nsu.yourStory.users.repository;

import com.nsu.yourStory.users.model.TimestampBean;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TimestampRepository<T extends TimestampBean> {
}
