package com.tarea.libreria.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarea.libreria.model.Autor;

@Repository
public interface AutorRepoInterface extends JpaRepository<Autor, Integer> {

}
