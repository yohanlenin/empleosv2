package net.mesa.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.mesa.model.Vacante;
import net.mesa.service.VacantesService;

@Controller
public class HomeController {
	@Autowired
	private VacantesService servicioVacante;
	
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
		model.addAttribute("vacante", vacante);
		
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

	@GetMapping("/")
	public String mostrarHome(Model model) {
		
		List<Vacante> lista = servicioVacante.buscarTodas();
		model.addAttribute("vacante", lista);
		return "home";
	}
	
}
