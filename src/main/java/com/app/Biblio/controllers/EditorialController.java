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
@RequestMapping("/editoriales")
public class EditorialController {
	
	@Autowired
	private LibroService libroService;
	@Autowired
	private EditorialService editorialService; 
	
	 @GetMapping({"/listar","/"})
	 public String mostrarFormNuevoAutor(Model model) {
		 List<Editorial> editoriales=editorialService.listarTodosLasEditorial();
		 model.addAttribute("editoriales",editoriales);
		 return "editoriales/listar_editoriales";
	 }
	
	 @GetMapping("/nuevo")
	 public String mostrarFormNuevaEditorial(Model model) {
		 Editorial editorial=new Editorial();
		 model.addAttribute("editorial", editorial);

		 return "editoriales/form_editorial";
	 }
	 
	 @PostMapping("/guardar")
	 public String guardarEditorial(@ModelAttribute Editorial editorial)  {
		 editorialService.saveEditorial(editorial);
		 return "redirect:/editoriales/listar";
	 }
	
	 @GetMapping("/{id}")
	 public String mostrarEditorial(@PathVariable Long id, Model model) {
		 Optional<Editorial> editorialOptional= editorialService.buscarPorId(id);
		 if(editorialOptional.isPresent()) {
			 Editorial editorial=editorialOptional.get();
			 model.addAttribute("editorial",editorial);
			 model.addAttribute("libros",editorial.getLibros());
		 }
		 return "editoriales/mostrar_editorial";
	 }
	  
	 @GetMapping("/{id}/editar")
	 public String mostrarFormEditarEditorial(@PathVariable Long id, Model model) {
		 Optional<Editorial> editorial = editorialService.buscarPorId(id);
		 editorial.ifPresent(value->model.addAttribute("editorial",value));
		 return "editoriales/form_editorial";
	 }
	 
	 @PostMapping("/{id}/actualizar")
	 public String actualizarEditorial(@PathVariable Long id, @ModelAttribute Editorial editorial)  {
		 Optional<Editorial> editorialOptional = editorialService.buscarPorId(id);
		if(editorialOptional.isPresent()) {
			Editorial editorialActual= editorialOptional.get();
		   editorialActual.setNombre(editorial.getNombre());
			editorialService.saveEditorial(editorialActual);
		}
		 return "redirect:/editoriales/listar";
	 }
	 
	 @GetMapping("/{id}/eliminar")
	 public String elimnarAutor(@PathVariable Long id) throws ClassNotFoundException {
		 editorialService.eliminarEditorial(id);
		 return "redirect:/editoriales/listar";
	 }
	 
	 @GetMapping("/{id}/libros")
	 public String mostrarLibrosDeEditorial(@PathVariable Long id, Model model) {
		 Optional<Editorial> editorialOptional = editorialService.buscarPorId(id);
		 if(editorialOptional.isPresent()) {
			Editorial editorial= editorialOptional.get();
			model.addAttribute("editorial",editorial);   
			model.addAttribute("libros",editorial.getLibros());
			}
		 return "editoriales/mostrar_libros_editorial";
	 }

	 
}
