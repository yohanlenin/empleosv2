package net.mesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mesa.model.Categoria;
import net.mesa.service.ICategoriasService;

@Controller
@RequestMapping(value="/categorias")

public class CategoriasController {
	
	@Autowired
	private ICategoriasService servicioCategoria;
	
	
	// @GetMapping("/index")
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categoria> lista= servicioCategoria.buscarTodas();
		model.addAttribute("categorias", lista);
		return "categorias/listCategorias";
	}
	// @GetMapping("/create")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	// @PostMapping("/save")
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("ocurrio un error rn" + error.getDefaultMessage());
			}
			return "categorias/formCategoria";
		}
		servicioCategoria.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro guardado");
		return "redirect:/categorias/index";
	}
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idCategoria, RedirectAttributes attributes) {
		servicioCategoria.eliminar(idCategoria);
		attributes.addFlashAttribute("msg", "Registro eliminado");	
		return "redirect:/categorias/index";
	}


}
