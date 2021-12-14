package com.franrodriguez.springboot.rest.empleos.app.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franrodriguez.springboot.rest.empleos.app.entity.Categoria;
import com.franrodriguez.springboot.rest.empleos.app.entity.Vacante;
import com.franrodriguez.springboot.rest.empleos.app.service.IVacanteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/app")
public class VacanteController {
	
	@Autowired
	private IVacanteService vacanteService;
	
	private Logger log = org.slf4j.LoggerFactory.getLogger(VacanteController.class);
	
	@GetMapping("/home")
	public List<Vacante> home(){
		return vacanteService.findByEstatusAndDestacado("Aprobada", 1);
	}
	
	/** 
	 * Método para mostrar imágenes 
	 * */
	@GetMapping("/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		log.info(rutaArchivo.toString());
		Resource recurso = null;
		
		try {
			recurso =  new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {

		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se pudo cargar la imagen " +nombreFoto);
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attchment; filename=\"" +recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
		
	}
	
	@GetMapping("/categorias")
	public List<Categoria> listaCAtegorias(){
		return vacanteService.findAllCategorias();
	}
	
	@GetMapping("/home/verDetalle/{id}")
	public Vacante findById(@PathVariable Long id) {
		return vacanteService.findById(id);
	}
	

}
