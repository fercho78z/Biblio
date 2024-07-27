package com.app.Biblio.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.app.Biblio.entities.Autor;
import com.app.Biblio.entities.Libro;
import com.app.Biblio.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public Autor saveAutor(Autor autor) {
		// TODO Auto-generated method stub
		return autorRepository.save(autor);
	}

	@Override
	public Optional<Autor> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return autorRepository.findById(id);
	}

	@Override
	public Optional<Autor> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return autorRepository.findByNombre(nombre);
	}

	@Override
	public List<Autor> listarTodosLosAutor() {
		// TODO Auto-generated method stub
		return autorRepository.findAll();
	}

	@Override
	public Autor actualizarAutor(Autor autor) {
		// TODO Auto-generated method stub
		return autorRepository.save(autor);
	}

	@Override
	public void eliminarAutor(Long Id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Optional<Autor> optionalAutor= autorRepository.findById(Id);
		if(optionalAutor.isPresent()) {
			Autor autor = optionalAutor.get();
			eliminarRelacionesDeAutor(autor);
			autorRepository.deleteById(Id);
		}
		else {
			throw new ClassNotFoundException("Error ");
		}
		}

	@Override
	public List<Autor> buscarPorIds(List<Long> ids) {
		// TODO Auto-generated method stub
		return autorRepository.findAllById(ids);
	}

	public void eliminarRelacionesDeAutor(Autor autor) {
		// TODO Auto-generated method stub
		for(Libro libro:autor.getLibros()) {
		libro.getAutores().remove(autor);
		}
		autor.getLibros().clear();
	}
	
	
	
}
