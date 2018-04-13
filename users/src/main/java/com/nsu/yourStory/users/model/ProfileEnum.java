package com.nsu.yourStory.users.model;

import org.springframework.security.core.GrantedAuthority;

public enum ProfileEnum implements GrantedAuthority {

	MEDICO,
	PACIENTE,
	ADMINISTRADOR;

	@Override
	public String getAuthority() {
		return this.name();
	}
}
