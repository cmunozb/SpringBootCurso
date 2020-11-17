package com.tarea.libreria.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarea.libreria.model.Libro;

@Repository
public interface LibroRepoInterface extends JpaRepository<Libro, Integer>{

}