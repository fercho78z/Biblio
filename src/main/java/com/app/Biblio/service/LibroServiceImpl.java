package com.app.Biblio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Biblio.entities.Categoria;
import com.app.Biblio.entities.Libro;
import com.app.Biblio.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;
	@Override
	public Libro saveLibro(Libro libro) {
		// TODO Auto-generated method stub
		return libroRepository.save(libro);
	}

	@Override
	public Optional<Libro> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id);
	}

	@Override
	public Optional<Libro> buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return libroRepository.findByTitulo(titulo);
	}

	@Override
	public List<Libro> listarTodosLosLibro() {
		// TODO Auto-generated method stub
		return libroRepository.findAll();
	}

	@Override
	public Libro actualizarLibro(Libro libro) {
		// TODO Auto-generated method stub
		return libroRepository.save(libro);
	}

	@Override
	public void eliminarLibro(Long Id) {
		// TODO Auto-generated method stub
		libroRepository.deleteById(Id);
		
	}

	@Override
	public List<Libro> buscarPorCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return libroRepository.findByCategoria(categoria);
	}

}
