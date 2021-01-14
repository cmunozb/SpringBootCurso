package com.tarea.libreria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tarea.libreria.model.Libro;
import com.tarea.libreria.service.LibroService;
import com.tarea.libreria.exception.ModeloNotFoundException;

@RestController
@RequestMapping("/Libros")
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public ResponseEntity<List<Libro>> listar(){
		List<Libro> lista = libroService.listar();
		return new ResponseEntity<List<Libro>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Libro> listarId(@PathVariable("id") Integer id){
		if(id != null && id > 0) {
			Libro au = libroService.leerPorId(id);
			return new ResponseEntity<Libro>(au, HttpStatus.OK);
		}{
			return new ResponseEntity<Libro>(new Libro(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Libro> save(@Valid @RequestBody Libro libro){
		Libro au = libroService.save(libro);
		return new ResponseEntity<Libro>(au, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Libro> update(@Valid @RequestBody Libro libro){
		Libro au = libroService.update(libro);
		return new ResponseEntity<Libro>(au, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		Libro au = libroService.leerPorId(id);
		if(au.getIdLibro() == null) {
			throw new ModeloNotFoundException("Id No Encontrado "+id);
		}
		libroService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
