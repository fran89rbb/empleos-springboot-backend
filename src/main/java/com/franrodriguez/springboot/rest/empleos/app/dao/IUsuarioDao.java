package com.franrodriguez.springboot.rest.empleos.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.franrodriguez.springboot.rest.empleos.app.entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
	
	@Query("Select u from Usuario u where username = ?1")
	public Usuario findByUsername2(String username);

}
