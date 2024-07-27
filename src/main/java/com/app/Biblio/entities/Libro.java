package com.app.Biblio.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //crea un constructor sin atributos esto lo hace lombook
@AllArgsConstructor //crea un cosntructor con todos los atributos esto lo hace lombook
@Data //crea get y setter esto lo hace lombook
@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String titulo;


	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="editorial_id")
	private Editorial editorial;
	
	
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name= "libro_autor",
			   joinColumns=@JoinColumn(name="libro_id"),
			   inverseJoinColumns=@JoinColumn(name="autor_id")
	)
	
	
	private List<Autor> autores = new ArrayList<>();


	public Libro() {
		
	}


	public Libro(Long id, String titulo, Categoria categoria, Editorial editorial, List<Autor> autores) {
		super();
		Id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.editorial = editorial;
		this.autores = autores;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}


	public List<Autor> getAutores() {
		return autores;
	}


	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
}
