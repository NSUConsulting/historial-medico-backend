package com.nsu.yourStory.users.vo;

import com.nsu.yourStory.users.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class CustomUserDetails implements UserDetails {
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> profile;
	private Boolean locked;
	private Boolean enabled;

	public CustomUserDetails(User user) {
		this.username = user.getEmail();
		this.password = user.getPassword();
		List<GrantedAuthority> auth = new ArrayList<>();
		user.getProfile().forEach(role -> auth.add(new SimpleGrantedAuthority(role.getName())));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return profile;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}
