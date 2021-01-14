package com.tarea.libreria.dto;

import com.tarea.libreria.model.Libro;
import com.tarea.libreria.model.Prestamo;

import org.springframework.hateoas.ResourceSupport;


public class ConsultaDTO extends ResourceSupport {
	
	private Integer idConsulta;
	private Libro libro;
	private Prestamo prestamo;
	
	public Integer getIdConsulta() {
		return idConsulta;
	}
	
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	public Libro getLibro() {
		return libro;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public Prestamo getPrestamo() {
		return prestamo;
	}
	
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
}