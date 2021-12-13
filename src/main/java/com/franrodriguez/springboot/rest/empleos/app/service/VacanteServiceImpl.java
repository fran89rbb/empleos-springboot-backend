package com.franrodriguez.springboot.rest.empleos.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.franrodriguez.springboot.rest.empleos.app.dao.IVacanteDao;
import com.franrodriguez.springboot.rest.empleos.app.entity.Categoria;
import com.franrodriguez.springboot.rest.empleos.app.entity.Vacante;

@Service
public class VacanteServiceImpl implements IVacanteService {
	
	@Autowired
	private IVacanteDao vacanteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Vacante> findByEstatusAndDestacado(String estatus, int destacado) {
		return vacanteDao.findByEstatusAndDestacado(estatus, destacado);
	}

	@Override
	public List<Categoria> findAllCategorias() {
		return vacanteDao.findAllCategorias();
	}

}
