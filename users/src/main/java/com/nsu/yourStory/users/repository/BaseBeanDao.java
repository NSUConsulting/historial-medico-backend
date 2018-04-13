package com.nsu.yourStory.users.repository;

import com.nsu.yourStory.users.model.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseBeanDao<T extends BaseBean> extends TimestampRepository<T>, JpaRepository<T, Long> {

	Optional<T> findById(Long id);

	Optional<T> findByUuid(String uuid);

	void deleteByUuid(String uuid);

}
