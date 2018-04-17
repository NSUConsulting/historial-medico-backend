package com.nsu.yourStory.users.cnfg;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class PasswordEncoderHelper {

	private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public static PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
}