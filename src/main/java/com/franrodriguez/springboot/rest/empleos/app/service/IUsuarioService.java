package com.franrodriguez.springboot.rest.empleos.app.service;

import com.franrodriguez.springboot.rest.empleos.app.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);

}
