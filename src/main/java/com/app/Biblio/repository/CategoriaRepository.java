package com.app.Biblio.repository;

	import com.app.Biblio.entities.Categoria;
	import java.util.Optional;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	@Repository
	public interface CategoriaRepository extends JpaRepository<Categoria,Long>{

		Optional<Categoria> findByNombre(String nombre);
	}

