package com.franrodriguez.springboot.rest.empleos.app.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Vacante vacante = null;
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		try {
			vacante = vacanteService.findById(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(vacante == null) {
			response.put("mensaje", "El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Vacante>(vacante, HttpStatus.OK);	
	}
	
	@GetMapping("/vacantes")
	public List<Vacante> vacantes(){
		return vacanteService.findAll();
	}
	
	@PostMapping("/vacantes")
	@ResponseStatus(HttpStatus.CREATED)
	public Vacante save(@RequestBody Vacante vacante) {
		return vacanteService.save(vacante);
	}
	
	@PutMapping("/vacantes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Vacante update(@PathVariable Long id, @RequestBody Vacante vacante) {
		Vacante vacanteActual = vacanteService.findById(id);
		
		vacanteActual.setNombre(vacante.getNombre());
		vacanteActual.setDescripcion(vacante.getDescripcion());
		vacanteActual.setFecha(vacante.getFecha());
		vacanteActual.setSalario(vacante.getSalario());
        vacanteActual.setEstatus(vacante.getEstatus());
		vacanteActual.setDestacado(vacante.getDestacado());
		vacanteActual.setDetalles(vacante.getDetalles());
		
		return vacanteService.save(vacanteActual);
	}
	
	@DeleteMapping("/vacantes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		vacanteService.delete(id);
	}

}
