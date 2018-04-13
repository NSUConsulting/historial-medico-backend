package com.nsu.yourStory.users.repository;

import com.nsu.yourStory.users.model.LogicalDeleteableBean;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LogicalDeleteableDao<T extends LogicalDeleteableBean> extends BaseBeanDao<T> {
}
