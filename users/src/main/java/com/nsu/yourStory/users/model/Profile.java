package com.nsu.yourStory.users.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class Profile extends LogicalDeleteableBean {

	@NotNull
	@NotEmpty
	private String name;

	@ElementCollection(targetClass = Access.class)
	@JoinTable(name = "PROFILE_ACCESS", joinColumns = @JoinColumn(name = "PROFILE_ID"))
	@Column(name = "ACCESS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<Access> accesses;

}
