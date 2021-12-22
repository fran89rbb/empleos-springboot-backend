package com.franrodriguez.springboot.rest.empleos.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vacantes")
public class Vacante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "no puede esta vacío")
	@Column(name = "NOMBRE")
	private String nombre;

	@NotEmpty(message = "no puede esta vacío")
	@Column(name = "DESCRIPCION")
	private String descripcion;

	@NotNull(message = "no puede esta vacío")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "FECHA")
	private Date fecha;

	@NotNull(message = "no puede esta vacío")
	@Column(name = "SALARIO")
	private Double salario;

	@NotEmpty(message = "no puede esta vacío")
	@Column(name = "ESTATUS")
	private String estatus;

	@NotNull(message = "no puede esta vacío")
	@Column(name = "DESTACADO")
	private Integer destacado;

	@Column(name = "IMAGEN")
	private String imagen;

	@NotEmpty(message = "no puede esta vacío")
	@Column(name = "DETALLES", length = 15000)
	private String detalles;

	@NotNull(message = "no puede esta vacío")
	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getDestacado() {
		return destacado;
	}

	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategorias(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
