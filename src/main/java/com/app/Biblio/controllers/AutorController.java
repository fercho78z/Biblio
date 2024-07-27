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

import com.app.Biblio.entities.Autor;
import com.app.Biblio.service.AutorService;

@Controller
@RequestMapping("/autores")
public class AutorController {
	
 @Autowired
 private AutorService autorService;
 
 @GetMapping({"/listar","/"})
 public String listarAutores(Model model) {
	 
	 List<Autor> autores=autorService.listarTodosLosAutor();
	 model.addAttribute("autores",autores);
	 return "listar_autores";
 }


 @GetMapping({"/nuevo"})
 public String mostrarFormNuevoAutor(Model model) {
	 Autor autor=new Autor();
	 model.addAttribute("autor",autor);
	 model.addAttribute("accion", "/guardar");
	 return "form_autor";
 }

 @PostMapping("/guardar")
 public String guardarAutor(@ModelAttribute Autor autor)  {
	 autorService.saveAutor(autor);
	 return "redirect:/autores/listar";
 }
  
 @GetMapping("/editar/{id}")
 public String mostrarFormEditarAutor(@PathVariable Long id, Model model) {
	 Optional<Autor> autor = autorService.buscarPorId(id);
	 autor.ifPresent(value->model.addAttribute("autor",value));
	 return "form_autor";
 }
 
 @PostMapping("/actualizar")
 public String actualizarAutor(@ModelAttribute Autor autor)  {
	 autorService.saveAutor(autor);
	 return "redirect:/autores/listar";
 }
 
 
 @GetMapping("/eliminar/{id}")
 public String elimnarAutor(@PathVariable Long id) throws ClassNotFoundException {
	 autorService.eliminarAutor(id);
	 return "redirect:/autores/listar";
 }
 
}
