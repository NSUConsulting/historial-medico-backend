package com.nsu.yourStory.users.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity(name = "USER_INFO")
@Data
public class User extends LogicalDeleteableBean {

	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String password;
	@NotEmpty
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_profile", joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Profile> profile;
	@NotNull
	private Integer failedLogins;
	@NotNull
	private Boolean blocked;
	@NotNull
	private Date lastLogin;

}
