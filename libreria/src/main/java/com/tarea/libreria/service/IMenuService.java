package com.tarea.libreria.service;

import java.util.List;

import com.tarea.libreria.model.Menu;

public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
