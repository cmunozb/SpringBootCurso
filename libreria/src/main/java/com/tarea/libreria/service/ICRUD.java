package com.tarea.libreria.service;

import java.util.List;

public interface ICRUD <T> {
	
	T save(T obj);
	T update(T obj);
	List<T> listar();
	T leerPorId(Integer id);
	boolean delete(Integer id);
}