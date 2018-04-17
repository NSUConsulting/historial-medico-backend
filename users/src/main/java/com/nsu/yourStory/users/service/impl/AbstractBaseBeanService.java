package com.nsu.yourStory.users.service.impl;

import com.nsu.yourStory.users.model.BaseBean;

import java.util.UUID;

public abstract class AbstractBaseBeanService<T extends BaseBean> extends AbstractTimestampBeanService<T> {

	@Override
	public T prepareToCreate(T entity) {
		entity.setUuid(UUID.randomUUID().toString());
		return super.prepareToCreate(entity);
	}

}
