package com.tarea.libreria.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;
import javax.persistence.Table;

@Entity
@Table(name = "prestamo")
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPrestamo;
	
	@Column(name = "fecha_prestamo", nullable = true)
	private LocalDateTime fechaPrestamo;
	
	@Column(name = "fecha_compromiso", nullable = false)
	private LocalDateTime fechaCompromiso;
	
	@Column(name = "fecha_devolucion", nullable = false)
	private LocalDateTime fechaDevolucion;

	@ManyToOne
	@JoinColumn(name = "id_libro", nullable = false, foreignKey = @ForeignKey(name = "FK_prestamo_libro"))
	private Libro libro;
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "libro_prestamo", joinColumns = @JoinColumn(name = "id_libro", referencedColumnName = "idLibro"), inverseJoinColumns = @JoinColumn(name = "id_prestamo", referencedColumnName = "idPrestamo"))
	private List<Prestamo> prestamos;*/
	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public LocalDateTime getfechaPrestamo() {
		return fechaPrestamo;
	}

	public void setfechaPrestamo(LocalDateTime fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDateTime getfechaCompromiso() {
		return fechaCompromiso;
	}

	public void setfechaCompromiso(LocalDateTime fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}
	
	public LocalDateTime getfechadevolucion() {
		return fechaDevolucion;
	}

	public void setfechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	/*
	public List<Prestamo> getPrestamo() {
		return prestamos;
	}

	public void setPrestamo(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPrestamo == null) ? 0 : idPrestamo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		if (idPrestamo == null) {
			if (other.idPrestamo != null)
				return false;
		} else if (!idPrestamo.equals(other.idPrestamo))
			return false;
		return true;
	}
}
