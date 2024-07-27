package com.app.Biblio.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Biblio.entities.Autor;
import com.app.Biblio.entities.Categoria;
import com.app.Biblio.entities.Editorial;
import com.app.Biblio.entities.Libro;
import com.app.Biblio.service.AutorService;
import com.app.Biblio.service.CategoriaService;
import com.app.Biblio.service.EditorialService;
import com.app.Biblio.service.LibroService;
@Controller
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private LibroService libroService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private EditorialService editorialService; 
	@Autowired
	private AutorService autorService;
	
	
	 @GetMapping({"/listar","/"})
	 public String listarLibros(Model model) {
		 
		 List<Libro> libros=libroService.listarTodosLosLibro();
		 model.addAttribute("libros",libros);
		 return "libros/listar_libros";
	 }


	 @GetMapping("/nuevo")
	 public String mostrarFormNuevoLibro(Model model) {
		 Libro libro=new Libro();
		 model.addAttribute("libro", libro);
		 model.addAttribute("editoriales", editorialService.listarTodosLasEditorial());
		 model.addAttribute("categorias", categoriaService.listarTodosLasCategorias());
		 model.addAttribute("autores", autorService.listarTodosLosAutor() );
		 return "libros/form_libro";
	 }

	 @PostMapping("/guardar")
	 public String guardarLibro(@ModelAttribute Libro libro,@RequestParam("editorialId") Long editorialId, 
			 					@RequestParam("categoriaId") Long categoriaId,@RequestParam("autoresIds") List<Long> autoresIds)  {
		 
		 Optional<Editorial> editorial = editorialService.buscarPorId(editorialId);
		 editorial.ifPresent(libro::setEditorial);
		 Optional<Categoria> categoria = categoriaService.buscarPorId(categoriaId);
		 categoria.ifPresent(libro::setCategoria);
		 List<Autor> autores= autorService.buscarPorIds(autoresIds);
		 libro.setAutores(new ArrayList<>(autores));
		 libroService.saveLibro(libro);
		 return "redirect:/libros/listar";
	 }
	  
	 
	 
	 @GetMapping("/{id}/editar")
	 public String mostrarFormEditarLibro(@PathVariable Long id, Model model) {
		 Optional<Libro> libro= libroService.buscarPorId(id);
		 
		 if(libro.isPresent()){
		 model.addAttribute("libro", libro.get());
		 model.addAttribute("editoriales", editorialService.listarTodosLasEditorial());
		 model.addAttribute("categorias", categoriaService.listarTodosLasCategorias());
		 model.addAttribute("autores", autorService.listarTodosLosAutor() );
		 } 
		 return "libros/form_libro";
	 }
	 
	 @PostMapping("/{id}/guardar")
	 public String guardarLibro(@PathVariable Long id, @ModelAttribute Libro libro,@RequestParam("editorialId") Long editorialId, 
			 					@RequestParam("categoriaId") Long categoriaId,@RequestParam("autoresIds") List<Long> autoresIds)  {
		 
		 Optional<Editorial> editorial = editorialService.buscarPorId(editorialId);
		 editorial.ifPresent(libro::setEditorial);
		 Optional<Categoria> categoria = categoriaService.buscarPorId(categoriaId);
		 categoria.ifPresent(libro::setCategoria);
		 List<Autor> autores= autorService.buscarPorIds(autoresIds);
		 libro.setAutores(new ArrayList<>(autores));
		 
		
		 libroService.saveLibro(libro);
		 return "redirect:/libros/listar";
	 }
	
	 @PostMapping("/{id}/actualizar")
	 public String actualizarLibro(@PathVariable Long id, @ModelAttribute Libro libro,@RequestParam("editorialId") Long editorialId, 
			 					@RequestParam("categoriaId") Long categoriaId,@RequestParam("autoresIds") List<Long> autoresIds)  {
		 
		 Optional<Editorial> editorial = editorialService.buscarPorId(editorialId);
		 editorial.ifPresent(libro::setEditorial);
		 Optional<Categoria> categoria = categoriaService.buscarPorId(categoriaId);
		 categoria.ifPresent(libro::setCategoria);
		 List<Autor> autores= autorService.buscarPorIds(autoresIds);
		 libro.setAutores(new ArrayList<>(autores));
		 
		 libro.setId(id);
		 libroService.saveLibro(libro);
		 return "redirect:/libros/listar";
	 }
	 
	 @GetMapping("/{id}/autores")
	 public String mostrarAutoresDelLibro(@PathVariable Long id, Model model) {
		 Optional<Libro> libroOptional= libroService.buscarPorId(id);
		 if(libroOptional.isPresent()) {
			  Libro libro=libroOptional.get();
			 model.addAttribute("libro",libro);
			 model.addAttribute("autores",libro.getAutores());
		 }
		 return "libros/mostrar_autores_libros";
	 }
	 
	 
	 @GetMapping("/{id}/eliminar")
	 public String elimnarAutor(@PathVariable Long id) throws ClassNotFoundException {
		 libroService.eliminarLibro(id);
		 return "redirect:/libros/listar";
	 }
	 
	
	
	
	
}
