package com.franrodriguez.springboot.rest.empleos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franrodriguez.springboot.rest.empleos.app.entity.Vacante;
import com.franrodriguez.springboot.rest.empleos.app.service.IVacanteService;

@RestController
@RequestMapping(value = "/app")
public class VacanteController {
	
	@Autowired
	private IVacanteService vacanteService;
	
	@GetMapping("/home")
	public List<Vacante> home(){
		return vacanteService.findByEstatusAndDestacado("Aprobada", 1);
	}

}
