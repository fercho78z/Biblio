package com.app.Biblio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Biblio.entities.Categoria;
import com.app.Biblio.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	Optional <Libro> findByTitulo(String nombre);
	
	List<Libro> findByCategoria(Categoria categoria);

}