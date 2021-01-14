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

import com.tarea.libreria.model.Autor;
import com.tarea.libreria.service.AutorService;
import com.tarea.libreria.exception.ModeloNotFoundException;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public ResponseEntity<List<Autor>> listar(){
		List<Autor> lista = autorService.listar();
		return new ResponseEntity<List<Autor>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> listarId(@PathVariable("id") Integer id){
		if(id != null && id > 0) {
			Autor au = autorService.leerPorId(id);
			return new ResponseEntity<Autor>(au, HttpStatus.OK);
		}{
			return new ResponseEntity<Autor>(new Autor(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Autor> save(@Valid @RequestBody Autor autor){
		Autor au = autorService.save(autor);
		return new ResponseEntity<Autor>(au, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Autor> update(@Valid @RequestBody Autor autor){
		Autor au = autorService.update(autor);
		return new ResponseEntity<Autor>(au, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		Autor au = autorService.leerPorId(id);
		if(au.getIdAutor() == null) {
			throw new ModeloNotFoundException("Id No Encontrado "+id);
		}
		autorService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
