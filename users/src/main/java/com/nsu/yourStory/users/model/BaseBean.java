package com.nsu.yourStory.users.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public abstract class BaseBean extends TimestampBean {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Column(unique = true)
	private String uuid;

}
