package com.nsu.yourStory.users.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public abstract class LogicalDeleteableBean extends BaseBean {

	@NotNull
	private Boolean active;

}