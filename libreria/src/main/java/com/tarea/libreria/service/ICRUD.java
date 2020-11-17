package com.tarea.libreria.service;

import java.util.List;

public interface ICRUD <T> {
	
	T save(T obj);
	T update(T obj);
	List<T> getAll();
	T findById(Integer id);
	boolean delete(Integer id);
}