package com.app.Biblio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Biblio.entities.Categoria;
import com.app.Biblio.repository.CategoriaRepository;
@Service
public class CategoriaServiceImpl  implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	
	
	@Override
	public Categoria saveCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoria);
	}

	@Override
	public Optional<Categoria> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(id);
	}

	@Override
	public Optional<Categoria> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return categoriaRepository.findByNombre(nombre);
	}

	@Override
	public List<Categoria> listarTodosLasCategorias() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoria);
		
	}

	@Override
	public void eliminarCategoria(Long Id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(Id);
	}
	

}
