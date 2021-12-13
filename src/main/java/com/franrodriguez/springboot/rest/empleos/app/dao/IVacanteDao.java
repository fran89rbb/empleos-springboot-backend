package com.franrodriguez.springboot.rest.empleos.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.franrodriguez.springboot.rest.empleos.app.entity.Categoria;
import com.franrodriguez.springboot.rest.empleos.app.entity.Vacante;

@Repository
public interface IVacanteDao extends JpaRepository<Vacante, Long>{
	
	public List<Vacante> findByEstatusAndDestacado(String estatus, int destacado);
	
	@Query("from Categoria")
	public List<Categoria> findAllCategorias();

}
