package net.mesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mesa.model.Usuario;
import net.mesa.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")

public class UsuariosController {	   
		@Autowired
		IUsuariosService usuarioService;
	
	    @GetMapping("/index")
		public String mostrarIndex(Model model) {
    	
	    	List<Usuario> lista = usuarioService.buscarTodos();
	    	model.addAttribute("usuarios", lista);
	    	return "usuarios/listUsuarios";
		}
	    
	    @GetMapping("/delete/{id}")
		public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		    	
	    	
	    	usuarioService.eliminar(idUsuario);
	    	attributes.addFlashAttribute("msj", "Registro eliminado");
			return "redirect:/usuarios/index";
		}
	}

