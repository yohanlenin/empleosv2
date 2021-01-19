package net.mesa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mesa.model.Perfil;
import net.mesa.model.Usuario;
import net.mesa.model.Vacante;
import net.mesa.service.ICategoriasService;
import net.mesa.service.IUsuariosService;
import net.mesa.service.VacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private ICategoriasService serviceCategoria;
	
	@Autowired
	private VacantesService servicioVacante;
	
	@Autowired
    private IUsuariosService serviceUsuarios;
	

	@GetMapping("/")
	public String mostrarHome(Model model) {
		//YA son innecesarias las lineas sgtes por declaracion @ModelAttribute con el metodo setGenericos
		//List<Vacante> lista = servicioVacante.buscarTodas();
		//model.addAttribute("vacante", lista);
		return "home";
	}
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Vacante vacante, Model model) {
		System.out.println("Buscado por " + vacante);
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().
				withMatcher("descripcion", GenericPropertyMatchers.contains());
		Example<Vacante> example= Example.of(vacante, matcher);
		List<Vacante>  lista = servicioVacante.buscarByExample(example);
		model.addAttribute("vacantes", lista);
		return "home";
	}
	
	//Para string si los detecta vacios los cambia a null
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "usuarios/formRegistro";
	}
	
	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, BindingResult result, RedirectAttributes attributes) {

		Perfil perfil = new Perfil();
		perfil.setId(3); // Perfil USUARIO
		usuario.agregar(perfil);
		
		
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("ocurrio un error rn" + error.getDefaultMessage());
			}
			return "usuarios/formRegistro";
		}
		usuario.setFechaRegistro(new Date());
		usuario.setEstatus(1);
		serviceUsuarios.guardar(usuario);
		attributes.addFlashAttribute("msj", "Registro Exitoso");
		
		return "redirect:/usuarios/index";
	}//_________________________________________
	
	
	
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		
		List<Vacante> lista = servicioVacante.buscarTodas();
		model.addAttribute("listaV", lista);
		
		return "tabla";
	}
	
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para soporte");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		model.addAttribute("vacantes", vacante);
		
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model modelo) {
		
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de sistemas");
		lista.add("Auxliliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		modelo.addAttribute("empleos", lista);
		return "listado";
	}

	
	@ModelAttribute
	public void setGenericos(Model model) {
		Vacante vacanteSearch = new Vacante();
		vacanteSearch.reset();
		model.addAttribute("vacantes", servicioVacante.buscarDestacada());
		model.addAttribute("categorias", serviceCategoria.buscarTodas());
		model.addAttribute("search", vacanteSearch);
	}

}
