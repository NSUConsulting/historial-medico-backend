package com.nsu.yourStory.users.service.impl;

import com.nsu.yourStory.users.model.TimestampBean;

import java.util.Date;

public abstract class AbstractTimestampBeanService<T extends TimestampBean> {

	public T prepareToCreate(T entity) {
		Date currentDate = new Date();
		entity.setCreateDate(currentDate);
		entity.setLastUpdate(currentDate);
		return entity;
	}

	public T prepareToUpdate(T entity) {
		entity.setLastUpdate(new Date());
		return entity;
	}


}
