package com.app.Biblio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Biblio.entities.Editorial;
import com.app.Biblio.repository.EditorialRepository;
@Service
public class EditorialServiceImpl implements EditorialService{

	@Autowired
	private EditorialRepository editorialRepository; 
	
	@Override
	public Editorial saveEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		return editorialRepository.save(editorial);
	}

	@Override
	public Optional<Editorial> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return editorialRepository.findById(id);
	}

	@Override
	public Optional<Editorial> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return editorialRepository.findByNombre(nombre);
	}

	@Override
	public List<Editorial> listarTodosLasEditorial() {
		// TODO Auto-generated method stub
		return editorialRepository.findAll();
	}

	@Override
	public Editorial actualizarCategoria(Editorial editorial) {
		// TODO Auto-generated method stub
		return editorialRepository.save(editorial);
	}

	@Override
	public void eliminarEditorial(Long Id) {
		// TODO Auto-generated method stub
		editorialRepository.deleteById(Id);
	}

}
