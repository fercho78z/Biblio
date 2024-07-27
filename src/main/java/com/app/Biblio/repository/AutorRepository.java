package com.app.Biblio.repository;

import com.app.Biblio.entities.Autor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long>{

	Optional<Autor> findByNombre(String nombre);
}
