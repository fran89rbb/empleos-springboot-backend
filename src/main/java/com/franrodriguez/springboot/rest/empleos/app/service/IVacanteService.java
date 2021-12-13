package com.franrodriguez.springboot.rest.empleos.app.service;

import java.util.List;

import com.franrodriguez.springboot.rest.empleos.app.entity.Categoria;
import com.franrodriguez.springboot.rest.empleos.app.entity.Vacante;

public interface IVacanteService {
	
	public List<Vacante> findByEstatusAndDestacado(String estatus, int destacado);
	
	public List<Categoria> findAllCategorias();


}
