package com.app.Biblio.service;

import java.util.List;
import java.util.Optional;

import com.app.Biblio.entities.Editorial;

public interface EditorialService {

	
	Editorial saveEditorial(Editorial editorial);
	
	Optional <Editorial> buscarPorId(Long id);
	
	Optional <Editorial> buscarPorNombre(String nombre);
		
	List<Editorial> listarTodosLasEditorial();	
	
	Editorial actualizarCategoria(Editorial Editorial);
	
	void eliminarEditorial(Long Id);
	
}
