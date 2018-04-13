package com.nsu.yourStory.users.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "USER_INFO")
@Data
public class User extends LogicalDeleteableBean {
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String password;
	@NotEmpty
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> profile;
	@NotNull
	private Integer failedLogins;
	@NotNull
	private Boolean blocked;
	@NotNull
	private Boolean enabled;
}
