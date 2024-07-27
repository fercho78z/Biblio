package com.app.Biblio.service;

import java.util.List;
import java.util.Optional;
import com.app.Biblio.entities.Categoria;

public interface CategoriaService {


	Categoria saveCategoria(Categoria categoria);
	
	Optional <Categoria> buscarPorId(Long id);
	
	Optional <Categoria> buscarPorNombre(String nombre);
		
	List<Categoria> listarTodosLasCategorias();	
	
	Categoria actualizarCategoria(Categoria aategoria);
	
	void eliminarCategoria(Long Id) throws ClassNotFoundException;
	
}
