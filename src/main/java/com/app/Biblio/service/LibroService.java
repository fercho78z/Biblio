package com.app.Biblio.service;

import java.util.List;
import java.util.Optional;

import com.app.Biblio.entities.Categoria;
import com.app.Biblio.entities.Libro;

public interface LibroService {

	Libro saveLibro(Libro libro);
	
	Optional <Libro> buscarPorId(Long id);
	
	Optional <Libro> buscarPorTitulo(String titulo);
		
	List<Libro> listarTodosLosLibro();	
	
	Libro actualizarLibro(Libro libro);
	
	void eliminarLibro(Long Id);
	
	List <Libro> buscarPorCategoria(Categoria categoria);
}
