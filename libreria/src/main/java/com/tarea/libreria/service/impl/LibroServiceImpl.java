package com.tarea.libreria.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.libreria.model.Libro;
import com.tarea.libreria.repo.LibroRepoInterface;
import com.tarea.libreria.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	private LibroRepoInterface repo;

	@Override
	public Libro save(Libro obj) {
		return repo.save(obj);
	}

	@Override
	public Libro update(Libro obj) {
		return repo.save(obj);
	}

	@Override
	public List<Libro> getAll() {
		return repo.findAll();
	}

	@Override
	public Libro findById(Integer id) {
		Optional<Libro> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}{
			return new Libro();
		}
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
