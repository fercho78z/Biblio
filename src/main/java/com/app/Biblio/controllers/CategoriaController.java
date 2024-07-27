package com.app.Biblio.controllers;
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


import com.app.Biblio.entities.Categoria;
import com.app.Biblio.entities.Libro;
import com.app.Biblio.service.CategoriaService;
	   
import com.app.Biblio.service.LibroService;
@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	 private CategoriaService categoriaService;
	
	@Autowired
	 private LibroService libroService;
	 
	 @GetMapping({"/listar","/"})
	 public String listarCategorias(Model model) {
		 
		 List<Categoria> categoria=categoriaService.listarTodosLasCategorias();
		 model.addAttribute("categoria",categoria);
		 return "categorias/listar_categorias";
	 }


	 @GetMapping({"/nuevo"})
	 public String mostrarFormNuevaCategoria(Model model) {
		 model.addAttribute("categoria",new Categoria());
		 
		 return "categorias/form_categoria";
	 }

	 @PostMapping("/guardar")
	 public String guardarCategoria(@ModelAttribute Categoria categoria)  {
		Categoria categoriaGuradada = categoriaService.saveCategoria(categoria);
		List<Libro> libros=libroService.buscarPorCategoria(categoriaGuradada);
		categoriaGuradada.setLibros(libros);
		categoriaService.saveCategoria(categoria);
		 return "redirect:/categorias/listar";
	 }
	  
	 @GetMapping("/editar/{id}")
	 public String mostrarFormEditarCategoria(@PathVariable Long id, Model model) {
		 Optional<Categoria> categoria = categoriaService.buscarPorId(id);
		 categoria.ifPresent(value->model.addAttribute("categoria",value));
		 return "categorias/form_categoria";
	 }
	 @PostMapping("/actualizar/{id}")
	 public String actualizarCategoria(@PathVariable Long id, @ModelAttribute Categoria categoria) {
		 Categoria categoriaActual = categoriaService.buscarPorId(id).orElse(null);
		 if(categoriaActual!=null) {
		 categoria.setLibros(categoriaActual.getLibros());
		 categoriaService.actualizarCategoria(categoria);
		
	 }
		 return "categorias/form_categoria";
	 }
	 
	 @GetMapping("/eliminar/{id}")
	 public String elimnarAutor(@PathVariable Long id) throws ClassNotFoundException {
		 categoriaService.eliminarCategoria(id);
		 return "redirect:/categorias/listar";
	 }
	 

}
