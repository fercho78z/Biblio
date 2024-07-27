package com.app.Biblio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Biblio.entities.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Long>{
	Optional <Editorial> findByNombre(String nombre);

}
