package com.nsu.yourStory.users.service.impl;

import com.nsu.yourStory.users.model.LogicalDeleteableBean;

public abstract class AbstractLogicalDeleteableBeanService<T extends LogicalDeleteableBean> extends AbstractTimestampBeanService<T> {

	@Override
	public T prepareToCreate(T entity) {
		entity.setActive(true);
		return super.prepareToCreate(entity);
	}

}
