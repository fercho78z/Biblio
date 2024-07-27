package com.app.Biblio.service;

import java.util.List;
import java.util.Optional;

import com.app.Biblio.entities.Autor;

public interface AutorService {

	Autor saveAutor(Autor autor);
	
	Optional <Autor> buscarPorId(Long id);
	
	Optional <Autor> buscarPorNombre(String nombre);
		
	List<Autor> listarTodosLosAutor();	
	
	Autor actualizarAutor(Autor autor);
	
	void eliminarAutor(Long Id) throws ClassNotFoundException;
	
	List <Autor> buscarPorIds(List<Long> ids);
}



