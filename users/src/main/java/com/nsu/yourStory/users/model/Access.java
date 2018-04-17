package com.nsu.yourStory.users.model;

import org.springframework.security.core.GrantedAuthority;

public enum Access implements GrantedAuthority {
	CREAR_RECETA,
	CREAR_MEDICO,
	CREAR_INSTITUCION,
	ASOCIAR_MEDICO,
	CONSULTAR_HISTORIAL_OTRA_PERSONA,
	CONSULTAR_ESTUDIOS,
	LEER_RECETA,
	CREAR_DERIVACION;


	@Override
	public String getAuthority() {
		return this.name();
	}
}
