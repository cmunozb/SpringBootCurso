package com.tarea.libreria.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.libreria.model.Autor;
import com.tarea.libreria.repo.AutorRepoInterface;
import com.tarea.libreria.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	private AutorRepoInterface repo;

	@Override
	public Autor save(Autor obj) {
		return repo.save(obj);
	}

	@Override
	public Autor update(Autor obj) {
		return repo.save(obj);
	}

	@Override
	public List<Autor> getAll() {
		return repo.findAll();
	}

	@Override
	public Autor findById(Integer id) {
		Optional<Autor> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}{
			return new Autor();
		}
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}
}