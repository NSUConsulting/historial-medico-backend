package com.nsu.yourStory.users.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Role extends BaseBean {

	@NotNull
	@NotEmpty
	private String name;

}
