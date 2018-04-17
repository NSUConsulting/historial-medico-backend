package com.nsu.yourStory.users.security;

import com.nsu.yourStory.users.cnfg.PasswordEncoderHelper;
import com.nsu.yourStory.users.model.Access;
import com.nsu.yourStory.users.model.User;
import com.nsu.yourStory.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private PasswordEncoder passwordEncoder = PasswordEncoderHelper.getPasswordEncoder();

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		Optional<User> user = userService.readUserByEmail(username);
		if (!user.isPresent()) {
			throw new BadCredentialsException("The user not exist.");
		} else {
			if (!this.passwordEncoder.matches(password, user.get().getPassword())) {
				user.get().setFailedLogins(user.get().getFailedLogins()+1);
				if (Integer.valueOf(3).equals(user.get().getFailedLogins())) {
					user.get().setBlocked(true);
				}
				userService.updateUser(user.get());
				throw new BadCredentialsException("Password Incorrecto");
			}
			user.get().setFailedLogins(0);
			userService.updateUser(user.get());
			Set<Access> accesses = new HashSet<>();
			user.get().getProfile().forEach(profile -> ((ArrayList) accesses).addAll(profile.getAccesses()));
			return new UsernamePasswordAuthenticationToken(user.get(), password, accesses);
		}
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}
}
